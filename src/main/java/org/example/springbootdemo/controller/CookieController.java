package org.example.springbootdemo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cookie")
public class CookieController {
    @GetMapping
    public String showLoginForm(){
        return "login-form";
    }
    @PostMapping("/submit")
    public String submitForm(@RequestParam("username") String username, HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(10);
        httpServletResponse.addCookie(cookie);
        return "redirect:/cookie/show-info";
    }
    @GetMapping("/show-info")
    public String showInfo(@CookieValue("username") String username, Model model){
        model.addAttribute("username", username);
        return "show-info";
    }
}
