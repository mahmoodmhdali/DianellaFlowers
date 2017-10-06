/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.SubscriptionDao;
import com.dianellaflowers.model.Subscription;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("subscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionDao subscriptionDao;

    @Override
    public Subscription findByEmail(String email) {
        return subscriptionDao.findByEmail(email);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionDao.findAll();
    }

    @Override
    public void addSubscription(Subscription subscription) throws Exception {
            Subscription entity = findByEmail(subscription.getEmail());
            if (entity == null) {
                subscriptionDao.addSubscription(subscription);
            } else{
                entity.setDeletedAt(null);
            }
    }

}
