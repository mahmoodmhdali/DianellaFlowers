package com.dianellaflowers.service;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import java.util.List;

public interface UserCartService {

    void addUserCart(UserCart userCart) throws Exception;

    Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception;
    
    UserCart findById(Integer Id);
    
    List<UserCart> findBySessionId(String sessionId);

}
