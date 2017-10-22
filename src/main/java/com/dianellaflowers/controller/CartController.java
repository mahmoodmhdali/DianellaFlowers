/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.Subscription;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.BouquetService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/shipping")
    public String address(Model model) {
        if ((userCartService.findBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId())).size() <= 0) {
            return "error404";
        } else {
            model.addAttribute("tax", userCartService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId()) / 10);
            return "AddressCheckOut";
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<GenericResponse> addToCart(@RequestParam("id") Integer bouquetId) throws Exception {
        UserCart userCart = userCartService.addUserCart(new UserCart(RequestContextHolder.currentRequestAttributes().getSessionId(), false, new Date(), bouquetService.findById(bouquetId)));
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), userCart.getId() + "~" + userCartService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId()) + "~" + userCart.getQuantity(), bouquetService.findById(bouquetId).toString()), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart(@RequestParam("id") Integer userCartId) throws Exception {
        userCartService.removeUserCart(userCartId, RequestContextHolder.currentRequestAttributes().getSessionId());
        String totalPrice = Double.toString(userCartService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId()));
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", totalPrice), HttpStatus.OK);
    }

    @PostMapping("/clearCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart() throws Exception {
        userCartService.clearBySessionID(RequestContextHolder.currentRequestAttributes().getSessionId());
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", ""), HttpStatus.OK);
    }

    @PostMapping("/updateCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> updateCart(@RequestParam("cardID") String[] cartIds, @RequestParam("quantity") String[] cartQuantities) throws Exception {
        return new ResponseEntity<GenericResponse>(userCartService.updateCart(cartIds, cartQuantities), HttpStatus.OK);
    }

    @PostMapping("/orderDetail")
    @ResponseBody
    public ResponseEntity<String> orderDetail(ModelMap model) throws Exception {
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
