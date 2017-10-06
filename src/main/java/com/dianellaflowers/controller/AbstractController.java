package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.UserCartService;
import com.dianellaflowers.utilities.WebUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author Pc-Lenovo
 */
/* Abstaract Controller contains common methods 
*  used in other controllers AND NOT annotated by @Controller
*  Just extend this class to get the below functionality
 */
public abstract class AbstractController {

    @Autowired
    UserCartService userCartService;
    
    @ModelAttribute("remoteIP")
    public String getRemoteIP() {
        return WebUtils.getClientIp();
    }

    @ModelAttribute("userCartItems")
    public List<UserCart> userCartItems() {
        return userCartService.findBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
    }

    @ModelAttribute("userCartTotalPrice")
    public Double userCartTotalPrice() {
        List<UserCart> userCart = userCartService.findBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
        Double price = 0.0;
        for(UserCart cart:userCart){
            price = price + Double.parseDouble(cart.getBouquetID().getPrice());
        }
        return price;
    }

    public GenericResponse GetBindingResultErrors(BindingResult bindingResult, HashSet<String> bypassFields) {
        HashMap<String, String> mp = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if ((bypassFields != null && !bypassFields.contains(error.getField())) || bypassFields == null) {
                    mp.put(error.getField(), error.getDefaultMessage());
                }
            }
        }
        if (!mp.isEmpty()) {
            return new GenericResponse(ResponseStatus.VALIDATION_ERROR.ordinal(),ResponseMessageType.ININPUT.ordinal(), "Validation Error", mp);
        }
        return null;
    }

}
