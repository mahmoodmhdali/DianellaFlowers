/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.configuration.security;

import com.dianellaflowers.service.UserAttemptService;
import com.dianellaflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Development PC
 */
@Component("authenticationProvider")
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    UserAttemptService userAttemp;

    @Autowired
    @Qualifier("customUserDetailsService")
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService); //To change body of generated methods, choose Tools | Templates.
    }

    @Autowired
    @Qualifier("customUserDetailsService")
    @Override
    public void setPasswordEncoder(Object passwordEncoder) {
        super.setPasswordEncoder(passwordEncoder()); //To change body of generated methods, choose Tools | Templates.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            Authentication auth = super.authenticate(authentication);
            userAttemp.resetAttempts(authentication.getName());
            return auth;
        } catch (BadCredentialsException e) {
            userAttemp.updateAttempts(authentication.getName());
            throw new LockedException("Invalid username and/or password. ");
        } catch (LockedException e) {
            throw new LockedException("" + authentication.getName() + " account is locked! ");
        } catch (AccountExpiredException e) {
            throw new AccountExpiredException("" + authentication.getName() + " is expired ");
        } catch (DisabledException e) {
            throw new DisabledException("" + authentication.getName() + " is not enabled ");
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Invalid username and/or password.");
        }
    }

}
