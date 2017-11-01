/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.CheckoutRequestService;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Development PC
 */
@Controller
@RequestMapping("/payfort")
public class PayFortController extends AbstractController {

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @PostMapping(value = "/purchase/online/response", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String onlineResponse(@RequestBody final MultiValueMap<String, String> payfortResponse,Model model) throws NoSuchAlgorithmException {
        GenericResponse genericResponse = checkoutRequestService.afterPayfortResponse(payfortResponse,"online");
        if(genericResponse.getStatusCode() == 0){
            model.addAttribute("trackId", genericResponse.getStatusMessage());
            return "successPayment";
        } else {
            model.addAttribute("checkoutRequest", genericResponse.getResponseObject());
            model.addAttribute("errorMessage", genericResponse.getStatusMessage());
            return "AddressCheckOut";
        }
    }

    @PostMapping(value = "/purchase/offline/response", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void offlineResponse(@RequestBody final MultiValueMap<String, String> payfortResponse) throws NoSuchAlgorithmException {
        checkoutRequestService.afterPayfortResponse(payfortResponse,"offline");
    }

}
