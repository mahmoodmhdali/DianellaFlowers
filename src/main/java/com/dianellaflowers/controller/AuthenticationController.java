/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.model.Category;
import com.dianellaflowers.service.CategoryService;
import com.dianellaflowers.service.CheckoutRequestService;
import com.dianellaflowers.utilities.Utilities;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Development PC
 */
@Controller
public class AuthenticationController {

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    Utilities utilities;

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!utilities.isCurrentAuthenticationAnonymous()) {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String logIn(Model model) {
        if (utilities.isCurrentAuthenticationAnonymous()) {
            return "login";
        }
        model.addAttribute("orders", checkoutRequestService.getAllCheckoutRequests());
        return "Admin/Dashboard";
    }
    
    @ModelAttribute("categories")
    public List<Category> cateries() {
        return categoryService.findAll();
    }

}
