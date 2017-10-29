/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Bouquet;
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
@Repository("bouquetDao")
public class BouquetDaoImpl extends AbstractDao<Integer, Bouquet> implements BouquetDao {

    @Override
    public Bouquet findById(int id) {
        Bouquet bouquet = getByKey(id);
        return bouquet;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bouquet> findAll(String orderBy, boolean desc) {
        Criteria crit = createEntityCriteria();
        if (desc) {
            crit.addOrder(Order.desc(orderBy));
        } else {
            crit.addOrder(Order.asc(orderBy));
        }
        return (List<Bouquet>) crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bouquet> findByCategoryName(String category,String orderBy, boolean desc) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.isNull("removedAt"));
        crit.add(Restrictions.eq("published", true));
        if (desc) {
            crit.addOrder(Order.desc(orderBy));
        } else {
            crit.addOrder(Order.asc(orderBy));
        }
        crit.createAlias("categoryID", "category");
        crit.add(Restrictions.eq("category.path", category));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.setFetchMode("categoryID", FetchMode.JOIN);
        return (List<Bouquet>) crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bouquet> findHomePageProduct() {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.isNull("removedAt"));
        crit.add(Restrictions.eq("published", true));
        crit.add(Restrictions.eq("homePageProduct", true));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Bouquet>) crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bouquet> findCartBouquetBySessionID(String sessionID) {
        Criteria crit = createEntityCriteria();
        crit.createAlias("userCartCollection", "userCartCollectionAlias");
        crit.add(Restrictions.eq("userCartCollectionAlias.sessionID", sessionID));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Bouquet> bouquetList = (List<Bouquet>) crit.list();
        return bouquetList;
    }

}
