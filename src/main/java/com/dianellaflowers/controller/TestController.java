/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author Development PC
 */
@Controller
@RequestMapping("/test")
public class TestController extends AbstractController {

    @Autowired
    ServletContext context;

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
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                toReturn = toReturn + "File " + listOfFile.getName() + " || ";
            } else if (listOfFile.isDirectory()) {
                toReturn = toReturn + "Directory " + listOfFile.getName() + " || ";
            }
        }
        return toReturn;
    }

    @GetMapping("/getSessionID")
    @ResponseBody
    public String asdw() throws IOException {
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }

}
