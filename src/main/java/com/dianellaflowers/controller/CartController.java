/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.model.HelperCheckOut;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.BouquetService;
import com.dianellaflowers.service.CheckoutRequestService;
import com.dianellaflowers.service.UserCartService;
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
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    UserCartService userCartService;

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @GetMapping()
    public String cart() {
        return "cart";
    }

    @GetMapping("/successPayment/{trackId}")
    public String successPayment(Model model, @PathVariable String trackId) {
        CheckoutRequest checkoutRequest = checkoutRequestService.findByTrackIdOrSessionId(trackId, false, false, true);
        if (checkoutRequest == null) {
            return "error404";
        } else if (checkoutRequest.getResponseCode().equals("14") || checkoutRequest.getResponseCode().equals("00047")) {
            return "error404";
        }
        model.addAttribute("trackId", trackId);
        return "successPayment";
    }

    @GetMapping("/shipping")
    public String address(Model model) {
        CheckoutRequest checkoutRequest = checkoutRequestService.findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, false, true);
        if (checkoutRequest == null) {
            return "error404";
        } else {
            model.addAttribute("checkoutRequest", checkoutRequest);
            model.addAttribute("tax", checkoutRequestService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true) / 10);
            return "AddressCheckOut";
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<GenericResponse> addToCart(@RequestParam("id") Integer bouquetId) throws Exception {
        UserCart userCart = checkoutRequestService.addCheckoutRequest(new UserCart(new Date(), bouquetService.findById(bouquetId)));
        return new ResponseEntity<>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), userCart.getId() + "~" + checkoutRequestService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true) + "~" + userCart.getQuantity(), bouquetService.findById(bouquetId).toString()), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart(@RequestParam("id") Integer userCartId) throws Exception {
        userCartService.removeUserCart(userCartId, RequestContextHolder.currentRequestAttributes().getSessionId());
        if (checkoutRequestService.findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, true, true) == null) {
            checkoutRequestService.clearBySessionID(RequestContextHolder.currentRequestAttributes().getSessionId());
        }
        String totalPrice = Double.toString(checkoutRequestService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true));
        return new ResponseEntity<>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", totalPrice), HttpStatus.OK);
    }

    @PostMapping("/clearCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart() throws Exception {
        checkoutRequestService.clearBySessionID(RequestContextHolder.currentRequestAttributes().getSessionId());
        return new ResponseEntity<>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", ""), HttpStatus.OK);
    }

    @PostMapping("/updateCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> updateCart(@RequestParam("cardID") String[] cartIds, @RequestParam("quantity") String[] cartQuantities) throws Exception {
        return new ResponseEntity<>(userCartService.updateCart(cartIds, cartQuantities), HttpStatus.OK);
    }

    @PostMapping("/orderDetail")
    @ResponseBody
    public ResponseEntity<GenericResponse> orderDetail(ModelMap model, @Valid @ModelAttribute HelperCheckOut helperCheckOut, BindingResult result, @RequestParam("time") String time) throws Exception {
        GenericResponse genericResponse = this.GetBindingResultErrors(result, null);
        if (genericResponse == null) {
            genericResponse = checkoutRequestService.updateCheckoutRequets(helperCheckOut, time);
        }
        return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);
    }

}
