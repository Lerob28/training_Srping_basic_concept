package com.lerob.controller;

import com.lerob.service.inpl.LoggedUserManagementService;
import com.lerob.service.inpl.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping
    public String welcomePage(
        @RequestParam(required = false, defaultValue = "red") String color,
        @RequestParam(required = false, defaultValue = "unknown") String username,
        @RequestParam(required = false) String logout,
        Model model
    ) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String loggedUsername = loggedUserManagementService.getUsername();
        if(loggedUsername != null) {
            model.addAttribute("username", loggedUsername);
            model.addAttribute("color", color);
            model.addAttribute("loginCount", loginCountService.getCount());
            return "home";
        }

        return "redirect:/";
    }

    @GetMapping("/{color}")
    public String homePage(
        @PathVariable String color,
        Model model
    ) {
        model.addAttribute("username", "lerob28");
        model.addAttribute("color", color);
        return "home";
    }
}
