package me.sunjin.springbootdeveloper.controller;

import me.sunjin.springbootdeveloper.domain.User;
import me.sunjin.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {
    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPro")
    public String loginPro(@RequestParam String userid, @RequestParam String password) {
        User user = userService.findByUserid(userid);
        if (user.getPassword() == null || !user.getPassword().equals(password)) {
            return "redirect:/login";
        }
        return "redirect:/articles";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
