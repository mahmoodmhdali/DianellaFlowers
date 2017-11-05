/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.ContactUs;
import com.dianellaflowers.model.Subscription;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.ContactUsService;
import com.dianellaflowers.service.SubscriptionService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Development PC
 */
@Controller
public class RequestsController extends AbstractController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    ContactUsService contactUsService;

    @PostMapping("/addNewSubscription")
    @ResponseBody
    public ResponseEntity<GenericResponse> addSubscriberEmail(@Valid @ModelAttribute Subscription subscription, BindingResult result, ModelMap model) throws Exception {
        GenericResponse genericResponse = this.GetBindingResultErrors(result, null);
        if (genericResponse == null) {
            subscriptionService.addSubscription(subscription);
            genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", null);
        }
        return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);
    }

    @PostMapping("/addNewContactUs")
    @ResponseBody
    public ResponseEntity<GenericResponse> addContactUs(@Valid @ModelAttribute ContactUs contactUs, BindingResult result, ModelMap model) throws Exception {
        GenericResponse genericResponse = this.GetBindingResultErrors(result, null);
        if (genericResponse == null) {
            contactUsService.addSubscription(contactUs);
            genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", null);
        }
        return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);
    }

}
