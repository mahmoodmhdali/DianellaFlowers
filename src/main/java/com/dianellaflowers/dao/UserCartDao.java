package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import java.util.List;

public interface UserCartDao {

    UserCart addUserCart(UserCart userCart) throws Exception;

    Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception;
    
    void clearBySessionID(String sessionID);
    
    UserCart findById(Integer Id);
    
    List<UserCart> findBySessionId(String sessionId);
    
    UserCart findBySessioIdAndBouquetID(String sessionId, Integer bouquetId);
    
    double getCartTotal(String sessionId);

}
