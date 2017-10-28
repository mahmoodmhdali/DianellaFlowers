/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("userCartDao")
public class UserCartDaoImpl extends AbstractDao<Integer, UserCart> implements UserCartDao {

    @Override
    public UserCart addUserCart(UserCart userCart) throws Exception {
        persist(userCart);
        return userCart;
    }

    @Override
    public Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception {
        UserCart userCart = getByKey(userCartId);
        if (userCart.getCheckoutRequestId().getSessionID().equals(sessionId)) {
            delete(userCart);
            return userCart.getBouquetID();
        }
        return null;
    }

    @Override
    public UserCart findById(Integer Id) {
        UserCart userCart = getByKey(Id);
        return userCart;
    }

}
