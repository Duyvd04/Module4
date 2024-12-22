package org.example.springbootdemo.controller;

import org.example.springbootdemo.model.Clazz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/test")
public class GlobalSessionController {
    @GetMapping
    public String test(@SessionAttribute(value = "clazzes",required = false)List<Clazz> clazzes){
        for(Clazz clazz : clazzes){
            System.out.println(clazz.getName());
        }
        return "login-form";
    }
}
