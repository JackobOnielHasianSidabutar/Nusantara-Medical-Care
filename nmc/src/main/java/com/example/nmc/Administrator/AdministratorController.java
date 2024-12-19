package com.example.nmc.Administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nmc.DTO.DaftarDokter;
import com.example.nmc.DTO.PendaftaranPasien;
import com.example.nmc.Transaksi.Transaksi;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorRepository repo;

    @Autowired
    AdministratorService service;
    
    @GetMapping("/login")
    public String login() {
        return "AdminSignIn";
    }

    @GetMapping("/main")
    public String indexMain(Model model) {
        List<PendaftaranPasien> pendaftaranList = this.repo.showAll();
        model.addAttribute("pendaftaranList", pendaftaranList);
        return "AdminMain";
    }

    @GetMapping("/editjadwal")
    public String indexJadwal(Model model) {
        List<DaftarDokter> daftarDokter = this.repo.showDokter();
        model.addAttribute("daftarList", daftarDokter);
        return "AdminSistemMain";
    }

    @PostMapping("bayar")
    public String addTransaksi(@Valid @ModelAttribute Transaksi transaksi) {
        boolean check = service.transaksi(transaksi);

        if(check==false) {
            return null;
        }
        return "AdminMain";
    }

    // @PostMapping("/main")
    // public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, Model model) {
    //     model.addAttribute("name", usernameDokter);
    //     return "AdminMain"; 
    // }
}
