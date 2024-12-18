package com.example.nmc.Perawat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/perawat")
public class PerawatController {

    @PostMapping("/main")
    public String dokterMain(@RequestParam String usernamePerawat, @RequestParam String passwordPerawat, HttpSession session, Model model) {
        model.addAttribute("name", usernamePerawat);
        session.setAttribute("username", usernamePerawat);
        return "PerawatMain"; 
    }
}
