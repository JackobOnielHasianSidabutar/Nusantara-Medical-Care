package com.example.nmc.Pasien;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pasien")
public class PasienController {

    @PostMapping("/main")
    public String main(){
        return"PelangganMain";
    }

    @GetMapping("/login")
    public String login(){
        return"PelangganSignIn";
    }

    @GetMapping("/register")
    public String register(){
        return"PelangganRegister";
    }
}
