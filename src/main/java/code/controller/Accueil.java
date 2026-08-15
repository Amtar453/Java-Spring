package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accueil")
public class Accueil {

    @GetMapping
    public String home(Model model){
        return "integrated:accueil";
    }
}
