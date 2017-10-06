/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.UserProfile;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserProfile> implements UserDao {

    @Override
    public void save(UserProfile user) {
        persist(user);
    }

    @Override
    public List<UserProfile> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        //To avoid duplicates.
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<UserProfile> users = (List<UserProfile>) criteria.list();
        return users;
    }

    @Override
    public List<UserProfile> findAllAdmins() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.createAlias("rolesCollection", "role");
        criteria.add(Restrictions.eq("role.role", "Admin"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<UserProfile> users = (List<UserProfile>) criteria.list();
        return users;
    }

    @Override
    public UserProfile findById(int id) {
        UserProfile user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getAuthorities());
            Hibernate.initialize(user.getRoleCollection());
        }
        return user;
    }

    @Override
    public UserProfile findByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        UserProfile user = (UserProfile) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAuthorities());
            Hibernate.initialize(user.getRoleCollection());
        }
        return user;
    }

    @Override
    public void deleteByID(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        UserProfile user = (UserProfile) crit.uniqueResult();
        delete(user);
    }

    @Override
    public UserProfile findByEmailAndToken(String email, String token) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        crit.add(Restrictions.eq("resetPasswordToken", token));
        UserProfile user = (UserProfile) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAuthorities());
            Hibernate.initialize(user.getRoleCollection());
        }
        return user;
    }

    @Override
    public UserProfile findByIDWithCorporateProfile(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        crit.setFetchMode("corporateUserProfileCollection", FetchMode.JOIN);
        UserProfile user = (UserProfile) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAuthorities());
            Hibernate.initialize(user.getRoleCollection());
        }
        return user;
    }

    @Override
    public UserProfile findUserByEmailAndPasswordTokenWithCorporateProfile(String email, String passwordToken) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        crit.add(Restrictions.eq("password", passwordToken));
        crit.setFetchMode("corporateUserProfileCollection", FetchMode.JOIN);
        UserProfile user = (UserProfile) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAuthorities());
            Hibernate.initialize(user.getRoleCollection());
        }
        return user;
    }

}
