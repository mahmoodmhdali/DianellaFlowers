/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.model.UserAttempt;

/**
 *
 * @author Mahmoud
 */
public interface UserAttemptService {
    
    void updateAttempts(String email);

    void resetAttempts(String email);
    
    void updateLastModified(String email);
}
