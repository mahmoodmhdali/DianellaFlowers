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
import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

@Transactional
@Service("userCartService")
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    UserCartDao userCartDao;

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @Override
    public UserCart addUserCart(UserCart userCart) throws Exception {
        UserCart existingUserCart = checkoutRequestService.findBySessioIdAndBouquetID(userCart.getCheckoutRequestId().getSessionID(), userCart.getBouquetID().getId()).getUserCartCollectionn().get(0);
        if (existingUserCart != null) {
            existingUserCart.setQuantity(Integer.toString(Integer.parseInt(existingUserCart.getQuantity()) + 1));
            return existingUserCart;
        } else {
            return userCartDao.addUserCart(userCart);
        }
    }

    @Override
    public Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception {
        return userCartDao.removeUserCart(userCartId, sessionId);
    }

    @Override
    public UserCart findById(Integer Id) {
        return userCartDao.findById(Id);
    }

    @Override
    public GenericResponse updateCart(String[] IDs, String[] quantities) {
        GenericResponse genericResponse = null;
        if (IDs.length != quantities.length) {
            genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Internal Server Error !", "");
        } else {
            for (int i = 0; i < IDs.length; i++) {
                UserCart userCart = findById(Integer.parseInt(IDs[i]));
                if (userCart == null) {
                    genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Internal Server Error !", "");
                    break;
                } else if (!userCart.getCheckoutRequestId().getSessionID().equals(RequestContextHolder.currentRequestAttributes().getSessionId())) {
                    genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Internal Server Error !", "");
                    break;
                } else if (quantities[i] == null || quantities[i].equals("")) {
                    genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Quantity is required **", "");
                    break;
                } else {
                    try {
                        int quantity = Integer.parseInt(quantities[i]);
                        userCart.setQuantity(Integer.toString(quantity));
                    } catch (Exception ex) {
                        genericResponse = new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Not a Valid Number **", "");
                        break;
                    }
                }
            }
        }
        if (genericResponse == null) {
            genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), Double.toString(checkoutRequestService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true)), checkoutRequestService.findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, false));
        }
        return genericResponse;
    }

}
