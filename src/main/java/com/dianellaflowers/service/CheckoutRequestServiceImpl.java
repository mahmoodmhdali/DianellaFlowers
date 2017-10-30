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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    public UserCart addCheckoutRequest(UserCart userCart) throws Exception {
        List<UserCart> userCartList = Arrays.asList(userCart);
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true);
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
    public CheckoutRequest findByTrackId(String trackId) {
        return checkoutRequestDao.findByTrackId(trackId);
    }

    @Override
    public CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession) {
        return checkoutRequestDao.findByTrackIdOrSessionId(Id, findWithSession);
    }

    @Override
    public double getCartTotal(String sessionId) {
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(sessionId, true);
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
    public GenericResponse updateCheckoutRequets(HelperCheckOut helperCheckOut) {
        GenericResponse genericResponse = null;
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true);
        if (checkoutRequest != null) {
            try {
                checkoutRequest.setTrackId(Utilities.getSaltString(checkoutRequest.getId()));
                checkoutRequest.setFirstName(helperCheckOut.getFirstName());
                checkoutRequest.setLastName(helperCheckOut.getLastName());
                checkoutRequest.setEmail(helperCheckOut.getEmail());
                checkoutRequest.setPhoneNumber(helperCheckOut.getPhoneNumber());
                checkoutRequest.setCity("Beirut");
                checkoutRequest.setCardText(helperCheckOut.getCardText());
                checkoutRequest.setAddress(helperCheckOut.getAddress());
                checkoutRequest.setResponseCode("0");
                checkoutRequest.setResponseMessage("Pending On Payfort Page");
                
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                String toHash = "TESTSHAINaccess_code=xnE9X7l7TmhOklqA4nyqamount=1000command=PURCHASEcurrenc" +
                                "y=USDcustomer_email=mahmoudmhdali@gmail.comlanguage=enmerchant_identifier=ppEaCGylmerch" +
                                "ant_reference=XYZ9239-yu898TESTSHAIN";
                byte[] hash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
                String sha256hex = new String(Hex.encode(hash));
                
                HashMap<String, String> payfortForm = new HashMap<>();
                payfortForm.put("access_code", "xnE9X7l7TmhOklqA4nyq");
                payfortForm.put("amount", "1000");
                payfortForm.put("command", "PURCHASE");
                payfortForm.put("currency", "USD");
                payfortForm.put("customer_email", "mahmoudmhdali@gmail.com");
                payfortForm.put("language", "en");
                payfortForm.put("merchant_identifier", "ppEaCGyl");
                payfortForm.put("merchant_reference", "XYZ9239-yu898");
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

}
