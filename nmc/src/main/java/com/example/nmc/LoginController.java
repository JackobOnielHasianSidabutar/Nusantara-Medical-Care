package com.example.nmc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nmc.Pegawai.ListPasienDTO;
import com.example.nmc.Pegawai.ListPasienService;
import com.example.nmc.Pegawai.Pegawai;
import com.example.nmc.Pegawai.PegawaiService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/pegawai")
public class LoginController {


    private final PegawaiService pegawaiService;
    private final ListPasienService listPasienService;

    @GetMapping("dokter/login")
    public String logInDokter() {
        return "DokterSignIn";
    }

    @GetMapping("perawat/login")
    public String logInPerawat() {
        return "PerawatSignIn";
    }

    @PostMapping("/perawat/login")
    public String perawatMain(@RequestParam String usernamePerawat, @RequestParam String passwordPerawat, HttpSession session, Model model) {
        Pegawai pegawai = pegawaiService.findByUsername(usernamePerawat).orElse(null);
        model.addAttribute("name", pegawai.getNamapegawai());
        session.setAttribute("username", usernamePerawat);

        if (pegawai != null && pegawai.getPasswordpegawai().equals(passwordPerawat)) {
            // Jika login sukses
            System.out.println("Password cocok.");
            model.addAttribute("name", pegawai.getNamapegawai());
            session.setAttribute("username", usernamePerawat);  // Menyimpan username di session
            List<ListPasienDTO> listPasien = listPasienService.getListPasienHariIni();

            // Tambahkan data ke model
            model.addAttribute("listPasien", listPasien);
            return "PerawatMain";  // Halaman utama setelah login sukses
        } else {
            System.out.println("Password salah.");
            model.addAttribute("error", "Invalid username or password!");
            return "PerawatSignIn"; 
        }
    }

    @PostMapping("dokter/login")
    public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, HttpSession session, Model model) {
        Pegawai pegawai = pegawaiService.findByUsername(usernameDokter).orElse(null);
        model.addAttribute("name", usernameDokter);
        session.setAttribute("username", usernameDokter);

        if (pegawai != null && pegawai.getPasswordpegawai().equals(passwordDokter)) {
            // Jika login sukses
            System.out.println("Password cocok.");
            model.addAttribute("name", pegawai.getNamapegawai());
            session.setAttribute("username", usernameDokter);  // Menyimpan username di session
            List<ListPasienDTO> listPasien = listPasienService.getListPasienHariIni();

            // Tambahkan data ke model
            model.addAttribute("listPasien", listPasien);
            return "DokterMain";  // Halaman utama setelah login sukses
        } else {
            System.out.println("Password salah.");
            model.addAttribute("error", "Invalid username or password!");
            return "DokterSignIn"; 
        }
    }
}
