package code.controller;

import code.model.User;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class Profile {
    private final PolicyFactory sanitizerPolicy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    @GetMapping
    public String home(Authentication authentication, Model model) {
        model.addAttribute("currentUser", (User) authentication.getPrincipal());
        return "integrated:profile";
    }

    @PostMapping
    public String profile(Model model, @Valid @ModelAttribute("newUser") User user, final BindingResult errors){



        return "integrated:profil";
    }
}
