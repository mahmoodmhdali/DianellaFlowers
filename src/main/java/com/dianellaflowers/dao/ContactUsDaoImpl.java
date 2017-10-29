/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.ContactUs;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("contactUsDao")
public class ContactUsDaoImpl extends AbstractDao<Integer, ContactUs> implements ContactUsDao {

    @Override
    public ContactUs findByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        ContactUs contactUs = (ContactUs) crit.uniqueResult();
        return contactUs;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ContactUs> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("email"));
        crit.add(Restrictions.isNull("deletedAt"));
        return (List<ContactUs>) crit.list();
    }

    @Override
    public void addSubscription(ContactUs contactUs) throws Exception {
        persist(contactUs);
    }

}
