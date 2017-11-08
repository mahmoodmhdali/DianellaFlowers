/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.service.CheckoutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Development PC
 */
@Controller
@RequestMapping("/Admin")
public class AdminController extends AbstractController {

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @GetMapping("/Dashboard")
    public String dashboard(Model model) {
        model.addAttribute("orders", checkoutRequestService.getAllCheckoutRequests());
        return "Admin/Dashboard";
    }

    @GetMapping("/orderDetail/{trackId}")
    public String dashboard(Model model, @PathVariable String trackId) {
        CheckoutRequest checkoutRequest = checkoutRequestService.findByTrackIdOrSessionId(trackId, false, true, true);
        model.addAttribute("userCartTotalPriceByTrackId", checkoutRequestService.getCartTotal(trackId, false));
        model.addAttribute("checkoutRequest", checkoutRequest);
        model.addAttribute("userCartItems", checkoutRequest.getUserCartCollectionn());
        return "Admin/orderDetail";
    }

}
