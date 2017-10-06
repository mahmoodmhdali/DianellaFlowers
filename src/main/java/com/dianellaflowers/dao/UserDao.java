/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.UserProfile;
import java.util.List;

/**
 *
 * @author Development PC
 */
public interface UserDao {

    UserProfile findById(int id);

    UserProfile findByEmail(String email);

    void save(UserProfile user);

    void deleteByID(int id);

    List<UserProfile> findAllUsers();

    List<UserProfile> findAllAdmins();
    
    UserProfile findByEmailAndToken(String email, String token);
    
    UserProfile findByIDWithCorporateProfile(int id);
    
    UserProfile findUserByEmailAndPasswordTokenWithCorporateProfile(String email, String passwordToken);

}
