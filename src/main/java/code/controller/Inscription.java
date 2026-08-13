package code.controller;

import code.dataAccess.dao.UserDataAccess;
import code.model.User;
import code.service.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inscription")
public class Inscription {
    private UserDataAccess userDAO;
    private final UserDetailsImplementation userDetailsService;
    private final PolicyFactory sanitizerPolicy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    @Autowired
    public Inscription(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "integrated:inscription";
    }

    @PostMapping
    public String inscription(Model model, @ModelAttribute("user") User user, final BindingResult errors) {

        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            return "integrated:inscription";
        }

        return "integrated:authentifie";
    }
}
