/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.BouquetService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author Development PC
 */
@Controller
@RequestMapping("/cart")
public class CartController extends AbstractController {

    @Autowired
    BouquetService bouquetService;

    @GetMapping()
    public String cart() {
        return "cart";
    }

    @GetMapping("/successPayment")
    public String successPayment() {
        return "successPayment";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<GenericResponse> addToCart(@RequestParam("id") Integer bouquetId) throws Exception {
        UserCart userCart = userCartService.addUserCart(new UserCart(RequestContextHolder.currentRequestAttributes().getSessionId(), false, new Date(), bouquetService.findById(bouquetId)));
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), userCart.getId() + "-" + userCartService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId()), bouquetService.findById(bouquetId).toString()), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart(@RequestParam("id") Integer userCartId) throws Exception {
        Bouquet bouquet = userCartService.removeUserCart(userCartId, RequestContextHolder.currentRequestAttributes().getSessionId());
        String totalPrice = Double.toString(userCartService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId()));
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", totalPrice), HttpStatus.OK);
    }

}
