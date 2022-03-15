package com.sptest.sptest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    test
    @GetMapping
    public String home() {
        return "home";
    }
}