/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Subscription;
import com.dianellaflowers.model.UserCart;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("userCartDao")
public class UserCartDaoImpl extends AbstractDao<Integer, UserCart> implements UserCartDao {

    @Override
    public void addUserCart(UserCart userCart) throws Exception {
        persist(userCart);
    }

    @Override
    public Bouquet removeUserCart(Integer userCartId, String sessionId) throws Exception {
        UserCart userCart = getByKey(userCartId);
        if (userCart.getSessionID().equals(sessionId)) {
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

    @Override
    public List<UserCart> findBySessionId(String sessionId) {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("createdDate"));
        crit.add(Restrictions.eq("sessionID", sessionId));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.setFetchMode("bouquetID", FetchMode.JOIN);
        List<UserCart> userCartList = (List<UserCart>) crit.list();
        return userCartList;
    }

}
