/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.service.BouquetService;
import com.dianellaflowers.service.CheckoutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Development PC
 */
@Controller
public class ViewsController extends AbstractController {

    @Autowired
    BouquetService bouquetService;

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    @GetMapping("/PrivacyPolicy")
    public String PrivacyPolicy() {
        return "PrivacyPolicy";
    }

    @GetMapping("/TermsAndConditions")
    public String TermsAndConditions() {
        return "TermsAndConditions";
    }

    @GetMapping(value = {"/", "/home"})
    public String load(ModelMap model) {
        model.addAttribute("homeProducts", bouquetService.findHomePageProduct());
        return "home";
    }

}
