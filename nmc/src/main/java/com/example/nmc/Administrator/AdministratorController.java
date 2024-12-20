package com.example.nmc.Administrator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

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

import com.example.nmc.Pasien.Pasien;
import com.example.nmc.Pasien.PasienService;
import com.example.nmc.Pendaftaran.JdbcRepositoryPendaftaran;
import com.example.nmc.Pendaftaran.Pendaftaran;
import com.example.nmc.Pendaftaran.PendaftaranService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorRepository repo;

    @Autowired
    AdministratorService administratorService;
    
    @Autowired
    private PasienService pasienService;

    @Autowired
    private PendaftaranService pendaftaranService;

    @Autowired
    private JdbcRepositoryPendaftaran pendaftaranRepository;

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

    private LocalDate parseTanggal(String tanggal) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(tanggal, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Format tanggal tidak valid: " + tanggal);
        }
    }

    @PostMapping("bayar")
    public String addTransaksi(
        @RequestParam("tanggaltransaksi") String tanggaltransaksi,
        @RequestParam("totaltransaksi") double totaltransaksi,
        @RequestParam("jenistransaksi") String jenistransaksi
    ) {
        try {
            // Parsing tanggal
            LocalDate tglTransaksi = parseTanggal(tanggaltransaksi);

            // Membuat objek transaksi
            Transaksi transaksi = new Transaksi(tglTransaksi, totaltransaksi, jenistransaksi);

            // Menyimpan transaksi melalui service
            administratorService.transaksi(transaksi);

            // Redirect ke halaman utama
            return "redirect:/administrator/main";
        } catch (IllegalArgumentException e) {
            // Menangani kesalahan parsing tanggal
            System.err.println("Format tanggal tidak valid: " + e.getMessage());
            return "redirect:/error?message=Invalid+date+format";
        } catch (Exception e) {
            // Menangani kesalahan umum lainnya
            e.printStackTrace();
            return "redirect:/error?message=An+unexpected+error+occurred";
        }
}


    // @PostMapping("/main")
    // public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, Model model) {
    //     model.addAttribute("name", usernameDokter);
    //     return "AdminMain"; 
    // }

    @PostMapping("/main")
    public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, Model model) {
        model.addAttribute("name", usernameDokter);
        return "AdminMain"; 
    }

    @GetMapping("/pendaftaran")
    public String showAdminPendaftaran() {
        return "AdminPendaftaran";
    }

    @PostMapping("/pendaftaran")
    public String saveAdminPendaftaran(
        @RequestParam String nama_lengkap,
        @RequestParam String tanggal_lahir,
        @RequestParam String jenisKelamin,
        @RequestParam String nomor_ponsel,
        @RequestParam Integer id_klinik,
        @RequestParam String jam_mulai,
        Model model) {
    try {
        // Ambil data pasien dari kode sebelumnya (tidak diubah)
        Optional<Pasien> existingPasien = pasienService.findByPhoneNumber(nomor_ponsel);
        String norekammedispasien;

        if (existingPasien.isPresent()) {
            norekammedispasien = existingPasien.get().getNorekammedispasien();
        } else {
            Pasien pasien = new Pasien();
            pasien.setNamapasien(nama_lengkap);
            pasien.setTgllahirpasien(tanggal_lahir);
            pasien.setJeniskelaminpasien(jenisKelamin);
            pasien.setNohppasien(nomor_ponsel);

            pasienService.register(pasien);
            norekammedispasien = pasien.getNorekammedispasien();
        }

        // Bagian pendaftaran
        LocalTime time = LocalTime.parse(jam_mulai, DateTimeFormatter.ofPattern("HH:mm"));

        Pendaftaran pendaftaran = new Pendaftaran();
        int newId = pendaftaranRepository.getMaxIdPendaftaran() + 1;

        pendaftaran.setIdPendaftaran(newId);
        pendaftaran.setTglPendaftaran(LocalDate.now());
        pendaftaran.setJamMulai(time);
        pendaftaran.setJamAkhir(LocalTime.parse("23:59"));
        pendaftaran.setIdKlinik(id_klinik);

        // Simpan ke tabel pendaftaran dan pendaftaranpasien
        pendaftaranService.savePendaftaran(pendaftaran, norekammedispasien);

        return "redirect:/administrator/main";
    } catch (DateTimeParseException e) {
        model.addAttribute("errorMessage", "Format waktu tidak valid. Harap gunakan format HH:mm.");
        return "redirect:/administrator/pendaftaran?error=true";
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Terjadi kesalahan saat menyimpan pendaftaran.");
        return "redirect:/administrator/pendaftaran?error=true";
    }
}
}
