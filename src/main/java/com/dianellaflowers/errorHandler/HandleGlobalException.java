/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.errorHandler;

import com.dianellaflowers.model.Category;
import com.dianellaflowers.model.CheckoutRequest;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.service.CategoryService;
import com.dianellaflowers.service.CheckoutRequestService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Pc-Lenovo
 */
@ControllerAdvice
public class HandleGlobalException {

    @Autowired
    CheckoutRequestService checkoutRequestService;

    @Autowired
    CategoryService categoryService;

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String handleCustomException(Exception ex) {
        String msg = ex.getMessage();
        return "An error has occured please copy this message and contact the admin: " + msg;
    }

    @ExceptionHandler(value = {CannotCreateTransactionException.class})
    @ResponseBody
    public String handleHibernateException(CannotCreateTransactionException ex) {
        String msg = ex.getMessage();
        return "You can add any Hibernate error jsp page here \n error message: " + msg;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleError404(HttpServletRequest request, Exception e, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        CheckoutRequest checkoutRequest = checkoutRequestService.findByTrackIdOrSessionId(RequestContextHolder.currentRequestAttributes().getSessionId(), true, false, true);
        List<UserCart> userCart = null;
        if (checkoutRequest != null) {
            userCart = checkoutRequest.getUserCartCollectionn();
        }
        model.addAttribute("userCartItems", userCart);
        model.addAttribute("userCartTotalPrice", checkoutRequestService.getCartTotal(RequestContextHolder.currentRequestAttributes().getSessionId(), true));
        return "error404";
    }

}
