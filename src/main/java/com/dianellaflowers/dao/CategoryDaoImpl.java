/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.Category;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahmoud
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

    @Override
    public List<Category> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<Category>) crit.list();
    }

    public Category findByCategoryPath(String path) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("path", path));
        return (Category) crit.uniqueResult();
    }

}
