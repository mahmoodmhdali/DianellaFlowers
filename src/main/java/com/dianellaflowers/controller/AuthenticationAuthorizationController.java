/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.enumeration.ResponseMessageType;
import com.dianellaflowers.enumeration.ResponseStatus;
import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.model.Subscription;
import com.dianellaflowers.model.UserCart;
import com.dianellaflowers.response.GenericResponse;
import com.dianellaflowers.service.BouquetService;
import com.dianellaflowers.service.SubscriptionService;
import com.dianellaflowers.service.UserCartService;
import com.dianellaflowers.utilities.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author Development PC
 */
@Controller
public class AuthenticationAuthorizationController extends AbstractController {

    @Autowired
    ServletContext context;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    BouquetService bouquetService;

    @Autowired
    UserCartService userCartService;

    @GetMapping(value = {"/", "/"})
    public String load(ModelMap model) {
        return "home";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

    @GetMapping("/successPayment")
    public String successPayment() {
        return "successPayment";
    }

    @GetMapping("/products/{category}")
    public String products(ModelMap model, @PathVariable String category) {
        List<Bouquet> bouquetList = bouquetService.findByCategoryName(category);
        model.addAttribute("bouquetList", bouquetList);
        return "products";
    }

    @GetMapping("/rootPath")
    @ResponseBody
    public String testController() throws IOException {
        return context.getRealPath("/");
    }

    @GetMapping("/rootPathFolders")
    @ResponseBody
    public String test1() throws IOException {
        File folder = new File(context.getRealPath("/"));
        File[] listOfFiles = folder.listFiles();
        String toReturn = "";
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                toReturn = toReturn + "File " + listOfFiles[i].getName() + " || ";
            } else if (listOfFiles[i].isDirectory()) {
                toReturn = toReturn + "Directory " + listOfFiles[i].getName() + " || ";
            }
        }
        return toReturn;
    }

    @PostMapping("/addNewSubscription")
    @ResponseBody
    public ResponseEntity<GenericResponse> addMSISDN(@Valid @ModelAttribute Subscription subscription, BindingResult result, ModelMap model) throws Exception {
        GenericResponse genericResponse = this.GetBindingResultErrors(result, null);
        if (genericResponse == null) {
            subscriptionService.addSubscription(subscription);
            genericResponse = new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", null);
        }
        return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);
    }

    @GetMapping("/getFlowersByCategory")
    @ResponseBody
    public List<Bouquet> test1w() throws IOException {
        List<Bouquet> q = bouquetService.findByCategoryName("Wedding");
        return q;
    }

    @GetMapping(value = "/originalImage/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] readoriginalImage(@PathVariable Integer id) {
        Bouquet bouquet = bouquetService.findById(id);
        byte[] photo = Utilities.getFileAsBytes(bouquet.getOriginalImage());
        return photo;
    }

    @GetMapping(value = "/compressedImage/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] readcompressedImage(@PathVariable Integer id) {
        Bouquet bouquet = bouquetService.findById(id);
        byte[] photo = Utilities.getFileAsBytes(bouquet.getCompressedImagePath());
        return photo;
    }

    @PostMapping("/addToCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> addToCart(@RequestParam("id") Integer bouquetId) throws Exception {
        userCartService.addUserCart(new UserCart(RequestContextHolder.currentRequestAttributes().getSessionId(), false, new Date(), bouquetService.findById(bouquetId)));
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", bouquetService.findById(bouquetId).toString()), HttpStatus.OK);
    }

    @PostMapping("/removeFromCart")
    @ResponseBody
    public ResponseEntity<GenericResponse> removeFromCart(@RequestParam("id") Integer userCartId) throws Exception {
        Bouquet bouquet = userCartService.removeUserCart(userCartId, RequestContextHolder.currentRequestAttributes().getSessionId());
        return new ResponseEntity<GenericResponse>(new GenericResponse(ResponseStatus.SUCCESS.ordinal(), ResponseMessageType.ININPUT.ordinal(), "Success", bouquet.getPrice()), HttpStatus.OK);
    }

    @GetMapping("/getSessionID")
    @ResponseBody
    public String asdw() throws IOException {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }

}
