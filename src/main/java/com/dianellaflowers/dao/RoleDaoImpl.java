/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Role;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @Override
    public Role findById(int id) {
        Role role = getByKey(id);
        return role;
    }

    @Override
    public Role findByRole(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("role", type));
        Role role = (Role) crit.uniqueResult();
        return role;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("role"));
        return (List<Role>) crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAllForCorporate() {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.ne("role", "Admin"));
        crit.add(Restrictions.ne("role", "Support"));
        crit.add(Restrictions.ne("role", "Reporter"));
        return (List<Role>) crit.list();
    }

}
