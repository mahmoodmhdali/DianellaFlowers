/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import com.dianellaflowers.model.Bouquet;
import com.dianellaflowers.service.BouquetService;
import com.dianellaflowers.utilities.Utilities;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Development PC
 */
@Controller
@RequestMapping("/products")
public class BouquetController extends AbstractController {

    @Autowired
    BouquetService bouquetService;

    @Autowired
    ServletContext context;

    @GetMapping("/{category}")
    public String products(ModelMap model, @PathVariable String category) {
        List<Bouquet> bouquetList = bouquetService.findByCategoryName(category);
        model.addAttribute("bouquetList", bouquetList);
        return "products";
    }

    @GetMapping(value = "/originalImage/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] readoriginalImage(@PathVariable Integer id) {
        Bouquet bouquet = bouquetService.findById(id);
        byte[] photo = Utilities.getFileAsBytes(context.getRealPath(bouquet.getOriginalImage()));
        return photo;
    }

    @GetMapping(value = "/compressedImage/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] readcompressedImage(@PathVariable Integer id) {
        Bouquet bouquet = bouquetService.findById(id);
        byte[] photo = Utilities.getFileAsBytes(context.getRealPath(bouquet.getCompressedImagePath()));
        return photo;
    }

}
