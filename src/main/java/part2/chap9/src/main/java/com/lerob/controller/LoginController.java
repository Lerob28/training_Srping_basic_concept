package com.lerob.controller;

import com.lerob.processor.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping
    public String loginForm() {
        return "login";
    }

    @PostMapping
    public String authUser(
        @RequestParam String username,
        @RequestParam String password,
        Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.logUser();

        if (loggedIn) {
            model.addAttribute("message", "You are now logged in !");
            model.addAttribute("color", "green");
            return "redirect:/home";
        } else {
            model.addAttribute("message", "Login failed !");
            model.addAttribute("color", "red");
            return "login";
        }

    }
}
