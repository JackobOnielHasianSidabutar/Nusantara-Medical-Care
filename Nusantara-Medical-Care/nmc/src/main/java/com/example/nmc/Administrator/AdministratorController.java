package com.example.nmc.Administrator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    
    @GetMapping("/login")
    public String main() {
        return "AdminSignIn";
    }

    @PostMapping("/main")
    public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, Model model) {
        model.addAttribute("name", usernameDokter);
        return "AdminMain"; 
    }
}
