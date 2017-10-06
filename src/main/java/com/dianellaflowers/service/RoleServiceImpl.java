/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.RoleDao;
import com.dianellaflowers.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public Role findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Role findByRole(String type) {
        return dao.findByRole(type);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Role> findAllForCorporate() {
        return dao.findAllForCorporate();
    }

}
