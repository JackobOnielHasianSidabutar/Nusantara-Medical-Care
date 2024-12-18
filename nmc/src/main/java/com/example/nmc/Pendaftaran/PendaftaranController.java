package com.example.nmc.Pendaftaran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Controller
@RequestMapping("/pendaftaran")
public class PendaftaranController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/save")
    public String savePendaftaran(@RequestParam Map<String, String> payload, HttpSession session, Model model) {
        try {
            // Ambil data dari request dan session
            String idKlinik = session.getAttribute("idKlinik").toString();
            String jamMulai = payload.get("jam_mulai");
            LocalDate tglPendaftaran = LocalDate.now();

            // Simpan data pendaftaran ke database
            String sql = "INSERT INTO pendaftaran (tglPendaftaran, jamMulai, idKlinik, idAdministrator, noRekamMedis) VALUES (?, ?, ?, NULL, NULL)";
            jdbcTemplate.update(sql, tglPendaftaran, LocalTime.parse(jamMulai), Integer.parseInt(idKlinik));
            
            model.addAttribute("successMessage", "Pendaftaran berhasil disimpan!");
            System.out.println("Pendaftaran berhasil disimpan!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Terjadi kesalahan saat menyimpan pendaftaran.");
        }
        // Redirect kembali ke KlinikPage.html setelah berhasil menyimpan
        return "redirect:/pasien/klinikPage";
    }
}
