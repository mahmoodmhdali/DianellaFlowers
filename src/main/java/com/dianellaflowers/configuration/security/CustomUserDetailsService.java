/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.configuration.security;

import com.dianellaflowers.model.UserProfile;
import com.dianellaflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserProfile loadUserByUsername(String email) throws UsernameNotFoundException {
        UserProfile user = userService.findByEmail(email);

        if (user == null) {
            throw new BadCredentialsException("Username not found");
        }

        if (user.getDeletedAt() != null) {
            throw new BadCredentialsException("Your account is no more available");
        }

        user.setUserAuthorities(user.getRoleCollection());
        return user;
    }

}
