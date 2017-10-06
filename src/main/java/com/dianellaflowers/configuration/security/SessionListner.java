/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.configuration.security;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author mahmo
 */
public class SessionListner implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        // Session created successfully with setMaxInactiveInterval seconds
        // We can give every role a specific session timeout
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(-1); // unlimited session timeout
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        // Session destroyed after setMaxInactiveInterval seconds
        HttpSession session = se.getSession();
    }
}
