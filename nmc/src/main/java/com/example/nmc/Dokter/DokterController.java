package com.example.nmc.Dokter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dokter")
public class DokterController {

    // @GetMapping("/login")
    // public String logIn() {
    //     return "DokterSignIn";
    // }

    // @PostMapping("/main")
    // public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, HttpSession session, Model model) {
    //     model.addAttribute("name", usernameDokter);
    //     session.setAttribute("username", usernameDokter);
    //     return "DokterMain"; 
    // }

    @GetMapping("main")
    public String indexMain() {
        return "DokterMain";
    }

    @GetMapping("/jadwal")
    public String indexJadwal () {
        return "JadwalDokter";
    }
}
