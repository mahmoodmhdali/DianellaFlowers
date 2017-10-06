/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.UserAttempt;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Development PC
 */
@Repository("userAttemptDao")
public class UserAttepmtDaoImpl extends AbstractDao<Integer, UserAttempt> implements UserAttemptDao {

    @Override
    public void initAttempt(UserAttempt userAttempt) {
        persist(userAttempt);
    }

    @Override
    public UserAttempt findById(Integer userId) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userProfileId", userId));
        UserAttempt userAttempt = (UserAttempt) crit.uniqueResult();
        return userAttempt;
    }

}
