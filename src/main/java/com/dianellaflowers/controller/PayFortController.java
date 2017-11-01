/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.response.PayfortResponse;
import com.dianellaflowers.service.CheckoutRequestService;
import com.dianellaflowers.utilities.Utilities;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public GenericResponse onlineResponse(@RequestBody final MultiValueMap<String, String> payfortResponse) throws NoSuchAlgorithmException {
        return checkoutRequestService.afterPayfortResponse(payfortResponse);
    }

    @PostMapping(value = "/purchase/offline/response", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String offlineResponse(@RequestBody final MultiValueMap<String, String> payfortResponse) {
        String fullResponse = "";
        payfortResponse.remove("signature");
        Set<String> keys = payfortResponse.keySet();
        for (String key : keys) {
            fullResponse = fullResponse + key + "=" + payfortResponse.get(key);
        }

        return fullResponse.replace("[", "").replace("]", "");
    }

}
