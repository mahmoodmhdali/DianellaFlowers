package com.dianellaflowers.converter;

import com.dianellaflowers.model.Role;
import com.dianellaflowers.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual role objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;
    
    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role role = roleService.findById(id);
        return role;
    }

}
