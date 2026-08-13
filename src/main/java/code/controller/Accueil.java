package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accueil {

    @GetMapping("/accueil")
    public String home(Model model){
        return "integrated:accueil";
    }
}
