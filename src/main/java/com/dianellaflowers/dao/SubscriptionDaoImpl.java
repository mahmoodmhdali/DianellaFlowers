/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Subscription;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("subscriptionDao")
public class SubscriptionDaoImpl extends AbstractDao<Integer, Subscription> implements SubscriptionDao {

    @Override
    public Subscription findByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        Subscription subscription = (Subscription) crit.uniqueResult();
        return subscription;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subscription> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("email"));
        crit.add(Restrictions.isNull("deletedAt"));
        return (List<Subscription>) crit.list();
    }
    
    @Override
    public void addSubscription(Subscription subscription) throws Exception {
        persist(subscription);
    }

}
