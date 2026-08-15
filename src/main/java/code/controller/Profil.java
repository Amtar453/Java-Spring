package code.controller;

import code.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profil")
public class Profil {

    public String profil(Authentication authentication, Model model) {
        model.addAttribute("user", (User) authentication.getPrincipal());
        return "integrated:profil";
    }
}
