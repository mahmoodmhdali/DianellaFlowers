package com.dianellaflowers.service;

import com.dianellaflowers.model.Role;
import java.util.List;

public interface RoleService {

    Role findById(int id);

    Role findByRole(String type);

    List<Role> findAll();

    List<Role> findAllForCorporate();

}
