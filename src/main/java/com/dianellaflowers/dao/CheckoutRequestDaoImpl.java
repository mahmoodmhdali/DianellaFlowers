/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.CheckoutRequest;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("checkoutRequestDao")
public class CheckoutRequestDaoImpl extends AbstractDao<Integer, CheckoutRequest> implements CheckoutRequestDao {

    @Override
    public CheckoutRequest addCheckoutRequest(CheckoutRequest checkoutRequest) throws Exception {
        persist(checkoutRequest);
        return checkoutRequest;
    }

    @Override
    public CheckoutRequest findById(Integer Id) {
        CheckoutRequest checkoutRequest = getByKey(Id);
        return checkoutRequest;
    }

    @Override
    public CheckoutRequest findByTrackId(String TrackId) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("trackId", TrackId));
        CheckoutRequest checkoutRequest = (CheckoutRequest) crit.uniqueResult();
        return checkoutRequest;
    }

    @Override
    public CheckoutRequest findByTrackIdOrSessionId(String Id, boolean findWithSession, boolean forPayfortRequest) {
        Criteria crit = createEntityCriteria();
        crit.createAlias("userCartCollection", "userCartCollectionAlias");
        crit.createAlias("userCartCollectionAlias.bouquetID", "bouquetAlias");
        crit.addOrder(Order.asc("userCartCollectionAlias.createdDate"));
        if (!forPayfortRequest) {
            crit.add(Restrictions.ne("responseCode", "14"));
        }
        if (findWithSession) {
            crit.add(Restrictions.eq("sessionID", Id));
        } else {
            crit.add(Restrictions.eq("trackId", Id));
        }
        crit.setFetchMode("bouquetAlias.bouquetID", FetchMode.JOIN);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        CheckoutRequest checkoutRequest = (CheckoutRequest) crit.uniqueResult();
        if (checkoutRequest != null) {
            Hibernate.initialize(checkoutRequest.getUserCartCollectionn());
        }
        return checkoutRequest;
    }

    @Override
    public void clearBySessionID(String sessionID) {
        CheckoutRequest checkoutRequest = findByTrackIdOrSessionId(sessionID, true, false);
        delete(checkoutRequest);
    }

    @Override
    public CheckoutRequest findBySessioIdAndBouquetID(String sessionId, Integer bouquetId) {
        Criteria crit = createEntityCriteria();
        crit.createAlias("userCartCollection", "userCartCollectionAlias");
        crit.createAlias("userCartCollectionAlias.bouquetID", "bouquetAlias");
        crit.addOrder(Order.asc("userCartCollectionAlias.createdDate"));
        crit.add(Restrictions.eq("sessionID", sessionId));
        crit.add(Restrictions.eq("bouquetAlias.id", bouquetId));
        crit.add(Restrictions.ne("responseCode", "14"));
        CheckoutRequest checkoutRequest = (CheckoutRequest) crit.uniqueResult();
        if (checkoutRequest != null) {
            Hibernate.initialize(checkoutRequest.getUserCartCollectionn());
        }
        return checkoutRequest;
    }

}
