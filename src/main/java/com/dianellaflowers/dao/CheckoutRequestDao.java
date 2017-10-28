package com.dianellaflowers.dao;

import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.model.UserCart;
import java.util.List;

public interface CheckoutRequestDao {

    CheckoutRequest addCheckoutRequest(CheckoutRequest checkoutRequest) throws Exception;
    
    CheckoutRequest findById(Integer Id);
    
    CheckoutRequest findByTrackId(String TrackId);
    
    CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession);
    
    void clearBySessionID(String sessionID);
    
    CheckoutRequest findBySessioIdAndBouquetID(String sessionId, Integer bouquetId);

}
