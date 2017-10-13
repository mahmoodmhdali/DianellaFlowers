/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.service.BouquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping(value = {"/", "/"})
    public String load(ModelMap model) {
        model.addAttribute("homeProducts", bouquetService.findHomePageProduct());
        return "home";
    }
}
