/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.errorHandler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Pc-Lenovo
 */
@ControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String handleCustomException(Exception ex) {
        String msg = ex.getMessage();
        return "You can add any Hibernate error jsp page here \n error message: " + msg;
    }

    @ExceptionHandler(value = {CannotCreateTransactionException.class})
    @ResponseBody
    public String handleHibernateException(CannotCreateTransactionException ex) {
        String msg = ex.getMessage();
        return "You can add any Hibernate error jsp page here \n error message: " + msg;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleError404(HttpServletRequest request, Exception e) {
        return "error404";
    }

}
