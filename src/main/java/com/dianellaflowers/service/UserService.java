/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.model.UserAttempt;
import com.dianellaflowers.model.UserProfile;
import com.dianellaflowers.response.GenericResponse;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Development PC
 */
public interface UserService {

    UserProfile findById(int id);

    UserProfile findByEmail(String email);

    boolean isUnique(String email);

    boolean isUniqueFromOther(UserProfile userProfile);

    void saveUser(UserProfile user);

    GenericResponse updateUser(UserProfile user, Boolean endAllSessions, String oldEmail, String retunEntity, boolean updateLogedInUser, boolean isClientSideRequest, MultipartFile companyLogo);

    void deleteById(int id);

    UserProfile findByEmailAndToken(String email, String token);

    List<UserProfile> findAllUsers();

    List<UserProfile> findAllAdmins();

    void setAccountLocked(String email, boolean locked);

    UserAttempt getUserAttemptCollection(String email);

    GenericResponse resetPasswordToken(Integer UserID);
    
    GenericResponse resetPasswordToken(String email);

    GenericResponse resetPassword(String email, String newPassword, Boolean endAllSessions);

    UserProfile findByIDWithCorporateProfile(int id);

    GenericResponse resetPassword(int userId, String newPassword);

    UserProfile findUserByEmailAndPasswordTokenWithCorporateProfile(String username, String passwordToken);
}
