package com.dianellaflowers.service;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import java.util.List;

public interface UserCartService {

    UserCart addUserCart(UserCart userCart) throws Exception;

    Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception;
    
    UserCart findById(Integer Id);
    
    GenericResponse updateCart(String[] IDs, String[] quantities);

}
