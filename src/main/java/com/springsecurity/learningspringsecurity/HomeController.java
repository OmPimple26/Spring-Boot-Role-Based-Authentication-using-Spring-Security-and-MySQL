package com.springsecurity.learningspringsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // HTML page
    }

    @GetMapping("/admin/home")
    public String handleAdmin() {
        return "admin_home"; // HTML page
    }

    @GetMapping("/user/home")
    public String handleUser() {
        return "user_home"; // HTML page
    }

    @GetMapping("/login")
    public String login() {
        return "custom_login"; // HTML page
    }
}
