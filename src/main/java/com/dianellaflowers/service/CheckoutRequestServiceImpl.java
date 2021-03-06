/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.CheckoutRequestDao;
import com.dianellaflowers.dao.UserCartDao;
import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.model.HelperCheckOut;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.utilities.Utilities;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author Development PC
 */
@Service("checkoutRequestService")
@Transactional
public class CheckoutRequestServiceImpl implements CheckoutRequestService {

    @Autowired
    CheckoutRequestDao checkoutRequestDao;

    @Autowired
    UserCartDao userCartDao;

    @Autowired
    Utilities utilities;

    @Override
    public synchronized UserCart addCheckoutRequest(UserCart userCart) throws Exception {
        List<UserCart> userCartList = Arrays.asList(userCart);
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, false, true);
        if (checkoutRequest == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            userCart.setQuantity("1");
            checkoutRequest = new CheckoutRequest("-1", "Pending address and other infos", "", userCartList, RequestContextHolder.currentRequestAttributes().getSessionId(), new Date());
            userCart.setCheckoutRequestId(checkoutRequest);
            checkoutRequestDao.addCheckoutRequest(checkoutRequest);
        } else {
            userCart.setCheckoutRequestId(checkoutRequest);
            checkoutRequest = findBySessioIdAndBouquetID(RequestContextHolder.currentRequestAttributes().getSessionId(), userCart.getBouquetID().getId());
            if (checkoutRequest != null) {
                userCart = checkoutRequest.getUserCartCollectionn().get(0);
                userCart.setQuantity(Integer.toString(Integer.parseInt(userCart.getQuantity()) + 1));
            } else {
                userCart.setQuantity("1");
                userCartDao.addUserCart(userCart);
            }
        }
        return userCart;
    }

    @Override
    public CheckoutRequest findById(Integer Id) {
        return checkoutRequestDao.findById(Id);
    }

    @Override
    public CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession, boolean forPayfortRequest, boolean withUserCart) {
        return checkoutRequestDao.findByTrackIdOrSessionId(Id, findWithSession, forPayfortRequest, withUserCart);
    }

    @Override
    public double getCartTotal(String sessionId, boolean bysessionId) {
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(sessionId, bysessionId, !bysessionId, true);
        Double price = 0.0;
        if (checkoutRequest != null) {
            for (UserCart cart : checkoutRequest.getUserCartCollectionn()) {
                price = price + (Double.parseDouble(cart.getBouquetID().getPrice()) * Integer.parseInt(cart.getQuantity()));
            }
        }
        return Math.floor(price * 100) / 100;
    }

    @Override
    public void clearBySessionID(String sessionID) {
        checkoutRequestDao.clearBySessionID(sessionID);
    }

    @Override
    public CheckoutRequest findBySessioIdAndBouquetID(String sessionId, Integer bouquetId) {
        return checkoutRequestDao.findBySessioIdAndBouquetID(sessionId, bouquetId);
    }

    @Override
    public GenericResponse updateCheckoutRequets(HelperCheckOut helperCheckOut, String time) {
        GenericResponse genericResponse = null;
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, false, true);
        String totalAmount = Integer.toString((int) (getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true) * 100));
        String merchantIdentifier = Utilities.getSaltString(checkoutRequest.getId());
        if (checkoutRequest != null) {
            try {
                checkoutRequest.setShippingTime(time);
                checkoutRequest.setTrackId(merchantIdentifier);
                checkoutRequest.setShippingDateTime(helperCheckOut.getShippingDateTime());
                checkoutRequest.setAdditionalDetails(helperCheckOut.getAdditionalDetails());
                checkoutRequest.setFirstName(helperCheckOut.getFirstName());
                checkoutRequest.setLastName(helperCheckOut.getLastName());
                checkoutRequest.setEmail(helperCheckOut.getEmail());
                checkoutRequest.setPhoneNumber(helperCheckOut.getPhoneNumber());
                checkoutRequest.setCity("Beirut");
                checkoutRequest.setCardText(helperCheckOut.getCardText());
                checkoutRequest.setAddress(helperCheckOut.getAddress());
                checkoutRequest.setResponseCode("0");
                checkoutRequest.setResponseMessage("Pending On Payfort Page");
                checkoutRequest.setLastStatusUpdateDate(new Date());

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                String toHash = "access_code=7bbLJOM8b4LVIZGT5Kdzamount=" + totalAmount + "command=PURCHASEcurrency=USD"
                        + "customer_email=" + checkoutRequest.getEmail() + "language=enmerchant_identifier=wwIyqgyBmerch"
                        + "ant_reference=" + merchantIdentifier;
                byte[] hash = digest.digest(("DIANCHSECURITY" + toHash + "DIANCHSECURITY").getBytes(StandardCharsets.UTF_8));
                String sha256hex = new String(Hex.encode(hash));

                HashMap<String, String> payfortForm = new HashMap<>();
                payfortForm.put("access_code", "7bbLJOM8b4LVIZGT5Kdz");
                payfortForm.put("amount", totalAmount);
                payfortForm.put("command", "PURCHASE");
                payfortForm.put("currency", "USD");
                payfortForm.put("customer_email", checkoutRequest.getEmail());
                payfortForm.put("language", "en");
                payfortForm.put("merchant_identifier", "wwIyqgyB");
                payfortForm.put("merchant_reference", merchantIdentifier);
                payfortForm.put("signature", sha256hex);

                genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), checkoutRequest.getTrackId(), payfortForm);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CheckoutRequestServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Internal Server Error!", "");
        }
        return genericResponse;
    }

    @Override
    public GenericResponse afterPayfortResponse(MultiValueMap<String, String> payfortResponse, String userStatus) throws NoSuchAlgorithmException {
        GenericResponse genericResponse = null;
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(payfortResponse.get("merchant_reference").get(0), false, true, true);
        if (checkoutRequest != null) {
            if (Utilities.checkIfValidPayfortResponse(payfortResponse)) {
                checkoutRequest.setLastStatusUpdateDate(new Date());
                checkoutRequest.setResponseCode(payfortResponse.get("status").get(0));
                checkoutRequest.setResponseMessage(payfortResponse.get("response_message").get(0));
                checkoutRequest.setUserStatus(userStatus);
                if (payfortResponse.get("card_number") != null) {
                    checkoutRequest.setCardNumber(payfortResponse.get("card_number").get(0));
                }
                if (payfortResponse.get("customer_ip") != null) {
                    checkoutRequest.setCustomerIP(payfortResponse.get("customer_ip").get(0));
                }
                if (payfortResponse.get("status").get(0).equals("14") || payfortResponse.get("response_code").get(0).equals("00047")) {
                    if (checkoutRequest.getCheckoutDate() == null) {
                        try {
                            List<String> sendToList = new ArrayList<String>();
                            sendToList.add("dianellaflowers@gmail.com");
                            String[] sendTo = new String[sendToList.size()];
                            sendToList.toArray(sendTo);
                            utilities.sendEmail("You have a new order with track ID : " + checkoutRequest.getTrackId() + 
                                    " for : " + checkoutRequest.getFirstName() + " " + checkoutRequest.getLastName() + 
                                    " Phone number : " + checkoutRequest.getPhoneNumber(), sendTo, "New DianellaFlowers Order");
                        } catch (AddressException ex) {
                            Logger.getLogger(CheckoutRequestServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    checkoutRequest.setCheckoutDate(new Date());
                    genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.NONE.ordinal(), checkoutRequest.getTrackId(), "");
                    if (payfortResponse.get("response_code").get(0).equals("00047")) {
                        checkoutRequest.setResponseCode("00047");
                    }
                } else {
                    genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.ININPUT.ordinal(), payfortResponse.get("response_message").get(0), checkoutRequest);
                }
            } else {
                genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Not a valid signature!", checkoutRequest);
            }
        } else {
            genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.ININPUT.ordinal(), "No such track ID!", checkoutRequest);
        }
        return genericResponse;
    }

    @Override
    public List<CheckoutRequest> getAllCheckoutRequests() {
        return checkoutRequestDao.getAllCheckoutRequests();
    }

}
