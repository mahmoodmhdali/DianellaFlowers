/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.model.UserAttempt;
import com.dianellaflowers.utilities.Utilities;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userAttemptService")
public class UserAttemptServiceImpl implements UserAttemptService {

    @Autowired
    UserService userService;

    @Autowired
    private Environment environment;

    @Override
    public void updateAttempts(String email) {
        int numberOfSecBetweenAttempts = Integer.parseInt(environment.getRequiredProperty("login.numberOfSecondsBetweenAttempts"));
        int numberOfAttempts = Integer.parseInt(environment.getRequiredProperty("login.numberOfAttemptsPerUserLogIn"));

        UserAttempt userAttempt = userService.getUserAttemptCollection(email);
        if (userAttempt != null) {
            if (Utilities.getTimeDiffSec(userAttempt.getLastModified(), new Date()) < numberOfSecBetweenAttempts) {
                userAttempt.setAttempt(userAttempt.getAttempt() + 1);
            } else {
                userAttempt.setAttempt(1);
            }

            userAttempt.setLastModified(new Date());
            if (userAttempt.getAttempt() >= numberOfAttempts) {
                userService.setAccountLocked(email, false);
            }
        }
    }

    @Override
    public void resetAttempts(String email) {
        UserAttempt userAttempt = userService.getUserAttemptCollection(email);
        if (userAttempt != null) {
            userAttempt.setAttempt(0);
        }
    }

    @Override
    public void updateLastModified(String email) {
        UserAttempt userAttempt = userService.getUserAttemptCollection(email);
        if (userAttempt != null) {
            userAttempt.setLastModified(new Date());
        }
    }

}
