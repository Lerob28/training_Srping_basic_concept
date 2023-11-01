package com.lerob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String welcomePage(
        @RequestParam(required = false, defaultValue = "red") String color,
        @RequestParam(required = false, defaultValue = "unknown") String username,
        Model model
    ) {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "home";
    }

    @GetMapping("/home/{color}")
    public String homePage(
        @PathVariable String color,
        Model model
    ) {
        model.addAttribute("username", "lerob28");
        model.addAttribute("color", color);
        return "home";
    }
}
