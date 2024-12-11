package com.example.nmc.Pasien;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pasien")
public class PasienController {

    @Autowired
    private PasienService pasienService;

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

    @PostMapping("/register")
    public String register(@RequestParam String namaPasien, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tglLahirPasien, @RequestParam String jenisKelaminPasien, @RequestParam String noHpPasien,  Model model){
        try{
            Pasien pasien = pasienService.register(namaPasien, tglLahirPasien, jenisKelaminPasien, noHpPasien);
            model.addAttribute("pasien", pasien);
            return "PelangganSignIn";
        } catch (IllegalArgumentException e){
            return "PelangganRegister";
        }
    }
}
