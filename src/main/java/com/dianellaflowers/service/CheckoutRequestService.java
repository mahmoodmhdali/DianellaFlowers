/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.model.HelperCheckOut;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;

/**
 *
 * @author Development PC
 */
public interface CheckoutRequestService {

    UserCart addCheckoutRequest(UserCart userCart) throws Exception;
    
    CheckoutRequest findById(Integer Id);
    
    CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession);
    
    double getCartTotal(String sessionId);
    
    void clearBySessionID(String sessionID);
    
    CheckoutRequest findBySessioIdAndBouquetID(String sessionId, Integer bouquetId);
    
    GenericResponse updateCheckoutRequets(HelperCheckOut helperCheckOut);
    
    CheckoutRequest findByTrackId(String TrackId);
    
}
