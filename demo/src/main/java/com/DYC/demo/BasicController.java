package com.DYC.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

@Controller
public class BasicController {

    @GetMapping("/")
    String hello(){
        return "mainPage.html";
    }

}
