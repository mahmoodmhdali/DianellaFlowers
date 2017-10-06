/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.UserCartDao;
import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userCartService")
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    UserCartDao userCartDao;

    @Override
    public void addUserCart(UserCart userCart) throws Exception {
        userCartDao.addUserCart(userCart);
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
    public List<UserCart> findBySessionId(String sessionId) {
        return userCartDao.findBySessionId(sessionId);
    }

}
