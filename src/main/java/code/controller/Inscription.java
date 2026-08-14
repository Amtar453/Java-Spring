package code.controller;

import code.dataAccess.dao.UserDataAccess;
import code.model.*;
import code.service.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.owasp.html.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/inscription")
public class Inscription {
    private UserDataAccess userDAO;
    private final UserDetailsImplementation userDetailsService;
    private final PolicyFactory sanitizerPolicy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    @Autowired
    public Inscription(UserDataAccess userDAO, UserDetailsImplementation userDetailsService) {
        this.userDAO = userDAO;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "integrated:inscription";
    }

    @PostMapping
    public String inscription(Model model, @Valid @ModelAttribute("user") User user, final BindingResult errors) {
        String username = user.getUsername();
        String name = user.getName();
        String firstName = user.getFirstName();
        String phoneNumber = user.getPhoneNumber();
        String postalCode = user.getLocality().getPostalCode();
        String city = user.getLocality().getCity();
        String street = user.getLocality().getAddress().getStreet();
        String number = user.getLocality().getAddress().getNumber();

        String cleanUsername = sanitizerPolicy.sanitize(username);
        String cleanName = sanitizerPolicy.sanitize(name);
        String cleanFirstName = sanitizerPolicy.sanitize(firstName);
        String cleanPhoneNumber = sanitizerPolicy.sanitize(phoneNumber);
        String cleanPostalCode = sanitizerPolicy.sanitize(postalCode);
        String cleanCity = sanitizerPolicy.sanitize(city);
        String cleanStreet = sanitizerPolicy.sanitize(street);
        String cleanNumber = sanitizerPolicy.sanitize(number);
        Locality locality = new Locality(cleanPostalCode, cleanCity, new Address(cleanStreet, cleanNumber));

        // Cle-valeur pour eviter la redondance
        HashMap<String, String[]> userPeer = new HashMap<>();
        userPeer.put(cleanUsername, new String[]{cleanUsername, "Nom d'utilisateur invalide"});
        userPeer.put(name, new String[]{cleanName, "Nom invalide"});
        userPeer.put(firstName, new String[]{cleanFirstName, "Prenom invalide"});
        userPeer.put(phoneNumber, new String[]{cleanPhoneNumber, "Numéro de téléphone invalide"});
        userPeer.put(postalCode, new String[]{cleanPostalCode, "Code postal invalide"});
        userPeer.put(city, new String[]{cleanCity, "Ville invalide"});
        userPeer.put(street, new String[]{cleanStreet, "Rue invalide"});
        userPeer.put(number, new String[]{cleanNumber, "Numéro invalide"});

        // Si erreur de validation Spring (avec annotation dans les modèles)
        if (errors.hasErrors()) {
            model.addAttribute("user", user);
            return "integrated:inscription";
        }

        // Si le nom d'utilisateur entree contient injection XSS
        for (String i: userPeer.keySet()) {
//            System.out.println(userPeer.get(i)[0] + " => " + i);
            if (!userPeer.get(i)[0].equals(i)) {
                model.addAttribute("error", userPeer.get(i)[1]);
                return "integrated:inscription";
            }
        }

        // Si username existe deja
        if (!userDetailsService.isUsernameAvailable(cleanUsername)) {
            model.addAttribute("error", "Ce nom d'utilisateur est existe deja.");
            return "integrated:inscription";
        }

        user.setUsername(cleanUsername);
        user.setName(cleanName);
        user.setFirstName(cleanFirstName);
        user.setEmail(user.getEmail());
        user.setPhoneNumber(cleanPhoneNumber);
        user.setLocality(locality);

        userDetailsService.registerUser(user);
        return "redirect:/login";
    }
}