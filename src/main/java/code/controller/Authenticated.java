package code.controller;

import code.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authenticated")
public class Authenticated {

    @GetMapping
    public String home(Authentication authentication, Model model) {

        model.addAttribute("user", (User) authentication.getPrincipal());
        return "integrated:authenticated";
    }
}