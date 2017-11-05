package com.dianellaflowers.dao;

import com.dianellaflowers.model.CheckoutRequest;
import java.util.List;

public interface CheckoutRequestDao {

    CheckoutRequest addCheckoutRequest(CheckoutRequest checkoutRequest) throws Exception;

    CheckoutRequest findById(Integer Id);

    CheckoutRequest findByTrackId(String TrackId);

    CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession, boolean forPayfortRequest);

    void clearBySessionID(String sessionID);

    CheckoutRequest findBySessioIdAndBouquetID(String sessionId, Integer bouquetId);
    
    List <CheckoutRequest> getAllCheckoutRequests();

}
