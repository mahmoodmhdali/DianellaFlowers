/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.response.PayfortResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/purchase/response")
    public ResponseEntity<?> createUser(@RequestBody PayfortResponse payfortResponse) {
        String her = payfortResponse.toString();
        return new ResponseEntity("Successfully login", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/purchase/response")
    @ResponseBody
    public String testRequest() throws UnsupportedEncodingException, IOException {
        String jsonRequestString = "{"
                + "\"command\" : \"PURCHASE\" , "
                + "\"access_code\" : \"xnE9X7l7TmhOklqA4nyq\", "
                + "\"merchant_identifier\" : \"ppEaCGyl\", "
                + "\"merchant_reference\" : \"XYZ9239-yu898\", "
                + "\"amount\" : \"10000\", "
                + "\"currency\" : \"AED\", "
                + "\"language\" : \"en\", "
                + "\"customer_email\" : \"mahmoudmhdali@gmail.com\", "
                + "\"signature\" : \"7cad05f0212ed933c9a5d5dffa31661acf2c827a\", "
                + "\"order_description\" : \"iPhone 6-S\"}";

        // Define and Initialize HttpClient
        HttpClient httpClient = HttpClientBuilder.create().build();
        // Intialize HttpPOST with FORT Payment services URL
        HttpPost request = new HttpPost("https://sbpaymentservices.payfort.com/FortAPI/paymentApi");
        // Setup Http POST entity with JSON String
        StringEntity params = new StringEntity(jsonRequestString);
        // Setup request type as JSON
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        // Post request to FORT
        HttpResponse response = httpClient.execute(request);
        // Read response using StringBuilder
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()), 65728);
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        // Print response
        return sb.toString();
    }

}
