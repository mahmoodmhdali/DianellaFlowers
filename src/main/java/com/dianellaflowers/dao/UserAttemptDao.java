/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.dao;

import com.dianellaflowers.model.UserAttempt;

/**
 *
 * @author Development PC
 */
public interface UserAttemptDao {

    void initAttempt(UserAttempt userAttempt);

    UserAttempt findById(Integer userId);
}
