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
    public String authenticated(Authentication authentication, Model model) {
        User userDetails = (User) authentication.getPrincipal();

        model.addAttribute("username", userDetails.getUsername());
        return "integrated:authentifie";
    }
}
