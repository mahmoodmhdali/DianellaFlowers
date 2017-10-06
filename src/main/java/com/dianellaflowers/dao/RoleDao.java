package com.dianellaflowers.dao;

import com.dianellaflowers.model.Role;
import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Role findByRole(String type);

    Role findById(int id);

    List<Role> findAllForCorporate();

}
