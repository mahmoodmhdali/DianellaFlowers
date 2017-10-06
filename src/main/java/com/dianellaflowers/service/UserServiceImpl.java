/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.UserDao;
import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.UserAttempt;
import com.dianellaflowers.model.UserProfile;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.utilities.SessionUtils;
import com.dianellaflowers.utilities.Utilities;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Development PC
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserAttemptService userAttemptService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SessionUtils sessionUtils;

    @Value("${main.page.url:Not Configured}")
    private String mainPageUrl;

    @Value("${mail.host:Not Configured}")
    private String mailHost;

    @Autowired
    Utilities utilities;

    @Override
    public List<UserProfile> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public List<UserProfile> findAllAdmins() {
        return userDao.findAllAdmins();
    }

    @Override
    public UserProfile findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public UserProfile findByEmail(String email) {
        return userDao.findByEmail(email.toLowerCase());
    }

    @Override
    public UserProfile findByEmailAndToken(String email, String token) {
        return userDao.findByEmailAndToken(email.toLowerCase(), token);
    }

    @Override
    public UserProfile findByIDWithCorporateProfile(int id) {
        return userDao.findByIDWithCorporateProfile(id);
    }

    @Override
    public UserProfile findUserByEmailAndPasswordTokenWithCorporateProfile(String username, String passwordToken) {
        return userDao.findUserByEmailAndPasswordTokenWithCorporateProfile(username.toLowerCase(), passwordToken);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteByID(id);
    }

    @Override
    public void saveUser(UserProfile user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail().trim().toLowerCase());
        user.setName(user.getName().trim().toLowerCase());
        UserAttempt userAttempt = new UserAttempt();
        userAttempt.setAttempt(0);
        userAttempt.setLastModified(new Date());
        user.setUserAttemptCollection(userAttempt);
        userAttempt.setUserProfileId(user);
        userDao.save(user);
    }

    @Override
    public GenericResponse updateUser(UserProfile user, Boolean endAllSessions, String oldEmail, String retunEntity, boolean updateLogedInUser, boolean isClientSideRequest, MultipartFile companyLogo) {
        HashMap<String, String> mp = new HashMap<>();
        UserProfile entity = findById(user.getId());
        if (entity != null) {
            if (user.getEmail() != null && !user.getEmail().toLowerCase().equals(entity.getEmail().toLowerCase()) && !isUniqueFromOther(user)) {
                mp.put("email", "Email already exist!");
                return new GenericResponse(ResponseStatus.VALIDATION_ERROR.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Validation Error", mp);
            } else {
                entity.setId(user.getId());
                if (user.getName() != null) {
                    entity.setName(user.getName().trim().toLowerCase());
                }
                if (user.getEmail() != null) {
                    entity.setEmail(user.getEmail().toLowerCase());
                }
                if (user.getPassword() != null && !user.getPassword().equals(entity.getPassword())) {
                    entity.setPassword(passwordEncoder.encode(user.getPassword()));
                }
                if (user.getRoleCollection() != null && isClientSideRequest == false) {
                    entity.setRoleCollection(user.getRoleCollection());
                }
                if (endAllSessions != null && endAllSessions == true) {
                    sessionUtils.expireUserSessions(oldEmail);
                }
                if (updateLogedInUser == true) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(entity, entity.getPassword(), SecurityContextHolder.getContext().getAuthentication().getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
                return new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Success", entity.toString());
            }
        } else {
            mp.put("email", "User does not exist!");
            return new GenericResponse(ResponseStatus.VALIDATION_ERROR.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Validation Error", mp);
        }
    }

    @Override
    public boolean isUnique(String email) {
        return findByEmail(email.toLowerCase()) == null;
    }

    @Override
    public void setAccountLocked(String email, boolean locked) {
        UserProfile user = findByEmail(email.toLowerCase());
        if (user != null) {
            user.setAccountLocked(locked);
        }
    }

    @Override
    public UserAttempt getUserAttemptCollection(String email) {
        UserAttempt userAttempt = null;
        UserProfile user = findByEmail(email.toLowerCase());
        if (user != null) {
            userAttempt = user.getUserAttemptCollection();
        }
        return userAttempt;
    }

    @Override
    public boolean isUniqueFromOther(UserProfile userProfile) {
        UserProfile user = findByEmail(userProfile.getEmail().toLowerCase());
        if (user == null) {
            return true;
        } else if (!user.getId().equals(userProfile.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public GenericResponse resetPasswordToken(Integer UserID) {
        UserProfile user = findById(UserID);
        if (user != null) {
            try {
                if (user != null && user.getDeletedAt() != null) {
                    return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.ININPUT.ordinal(), "User not found", "");
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                user.setResetPasswordToken(Utilities.generateTokenForPassword());
                user.setResetPasswordTokenValidity(calendar.getTime());
                String text = "To reset your password, click this link:\n" + mainPageUrl
                        + "/resetPassword/" + user.getEmail() + "/" + user.getResetPasswordToken() + "\n\n"
                        + "If you didn't request a password reset, you can ignore this message.";
                if (mailHost.equals("Not Configured")) {
                    HashMap<String, String> mp = new HashMap<>();
                    return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Mail not configured", mp);
                }
                String[] sendTo = {user.getEmail()};
                utilities.sendEmail(text, sendTo, "Reset Password Request");
                return new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.NOTIFICATION.ordinal(), "Token Sent Successfully", "");
            } catch (AddressException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), null, "User not found", "");
    }

    @Override
    public GenericResponse resetPasswordToken(String email) {
        UserProfile user = findByEmail(email);
        if (user != null) {
            try {
                if (user != null && user.getDeletedAt() != null) {
                    return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), null, "User not found", "");
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                user.setResetPasswordToken(Utilities.generateTokenForPassword());
                user.setResetPasswordTokenValidity(calendar.getTime());
                String text = "To reset your password, click this link:\n" + mainPageUrl + "/resetPassword/" + user.getEmail() + "/" + user.getResetPasswordToken() + "\n\n" + "If you didn't request a password reset, you can ignore this message.";
                if (mailHost.equals("Not Configured")) {
                    HashMap<String, String> mp = new HashMap<>();
                    return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), null, "Mail not configured", mp);
                }
                String[] sendTo = {user.getEmail()};
                utilities.sendEmail(text, sendTo, "Reset Password Request");
                return new GenericResponse(ResponseStatus.SUCCESS.ordinal(), null, "Token Sent Successfully", "");
            } catch (AddressException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new GenericResponse(ResponseStatus.VALIDATION_ERROR_AS_NOT.ordinal(), null, "User not found", "");
    }

    @Override
    public GenericResponse resetPassword(String email, String newPassword, Boolean endAllSessions) {
        UserProfile user = findByEmail(email);
        if (user != null) {
            UserProfile entity = user;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            entity.setResetPasswordToken(null);
            entity.setResetPasswordTokenValidity(null);
            entity.setPassword(passwordEncoder.encode(newPassword));
            if (endAllSessions == true) {
                sessionUtils.expireUserSessions(email);
            }
            return new GenericResponse(ResponseStatus.SUCCESS.ordinal(), null, "Success", "");
        } else {
            return new GenericResponse(ResponseStatus.ERROR.ordinal(), null, "Access Denied", "");
        }
    }

    @Override
    public GenericResponse resetPassword(int userId, String newPassword) {
        UserProfile user = findById(userId);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            return new GenericResponse(ResponseStatus.SUCCESS.ordinal(), null, "Success", "");
        } else {
            return new GenericResponse(ResponseStatus.ERROR.ordinal(), null, "Access Denied", "");
        }
    }

}
