package com.example.nmc.Pasien;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nmc.Pendaftaran.JdbcRepositoryPendaftaran;
import com.example.nmc.Pendaftaran.Pendaftaran;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/pasien")
public class PasienController {

    private final PasienService pasienService;
    // private final TwilioService twilioService;
    private final JdbcRepositoryPendaftaran pendaftaranRepository;
    

    public LocalDate parseTanggal(String inputTanggal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            return LocalDate.parse(inputTanggal, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggal tidak valid: " + inputTanggal);
        }
    }

    @GetMapping("/login")
    public String login(){
        return "PelangganSignIn";
    }

    @PostMapping("/login")
    public String checkNum(@RequestParam String noHP, HttpSession session){
        
        Pasien pasien = new Pasien();

        if (pasienService.isPhoneNumberRegistered(noHP)) {
            // Generate OTP
            // String otp = String.valueOf((int)(Math.random() * 900000) + 100000); // 6-digit OTP

            // Simpan OTP di session
            // session.setAttribute("otp", otp);
            // session.setAttribute("noHP", noHP);

            // Kirim OTP via WhatsApp
            // twilioService.sendOtp(noHP, otp);

            // System.out.println("OTP terkirim: " + otp); // Debugging
            return "redirect:/pasien/main"; // Pindah ke halaman verifikasi OTP
        } else {
            System.out.println("Nomor HP tidak ditemukan.");
            return "redirect:/pasien/login";
        }
        // pasienService.login(noHP);
        // if (pasien != null && pasienService.isPhoneNumberRegistered(noHP)) {
        //     // Jika login sukses
        //     System.out.println("No HP ada.");
        //     return"redirect:/pasien/main";  // Halaman utama setelah login sukses
        // } else {
        //     System.out.println("no hp salah.");
        //     return "redirect:/pasien/login"; 
        // }
    }

    // @GetMapping("/otp")
    // public String otp(){
    //     return "PelangganOTP";
    // }

    // @PostMapping("/verify-otp")
    // public String verifyOtp(@RequestParam String inputOtp, HttpSession session) {
    //     String otp = (String) session.getAttribute("otp");
    //     String noHP = (String) session.getAttribute("noHP");

    //     if (otp != null && otp.equals(inputOtp)) {
    //         session.removeAttribute("otp");
    //         session.setAttribute("loggedInUser", noHP);

    //         System.out.println("Login berhasil untuk nomor HP: " + noHP);
    //         return "redirect:/pasien/main";
    //     } else {
    //         System.out.println("OTP salah.");
    //         return "redirect:/pasien/verify-otp";
    //     }
    // }


    @GetMapping("/main")
    public String main(){
        return "PelangganMain";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "PelangganRegister";
    }

    @PostMapping("/register")
    public String register(@RequestParam String nama, @RequestParam String dob, @RequestParam String jenisKelamin, @RequestParam String noTelepon, Model model) throws Exception {
        if (nama.isEmpty() || dob.isEmpty() || jenisKelamin.isEmpty() || noTelepon.isEmpty()) {
            throw new IllegalArgumentException("Semua field wajib diisi!");
        }

        // Buat objek pasien
        Pasien pasien = new Pasien();
        pasien.setNamapasien(nama);
        pasien.setTgllahirpasien(dob);
        pasien.setJeniskelaminpasien(jenisKelamin);
        pasien.setNohppasien(noTelepon);

        // Simpan data pasien
        pasienService.register(pasien);

        // Redirect ke halaman sukses
        System.out.print(pasien.getNorekammedispasien());
        return "redirect:/pasien/login";
    }
    @GetMapping("/klinikPage")
    public String klinikPage() {
        return "KlinikPage"; // Pastikan file KlinikPage.html ada di templates
    }

    @GetMapping("/jadwaldokter")
    public String jadwalDokter() {
        return "JadwalDokter"; // Pastikan file templates/JadwalDokter.html ada
    }
    
    @PostMapping("/jadwaldokter")
    public String savePendaftaran(
        @RequestParam String jam_mulai,
        @RequestParam int id_klinik,
        HttpSession session) {

        try {
            // Ambil nomor HP pasien dari sesi
            String noHP = (String) session.getAttribute("noHP");
            if (noHP == null || noHP.isEmpty()) {
                throw new IllegalStateException("Session tidak valid. Harap login terlebih dahulu.");
            }

            // Gunakan findByPhoneNumber untuk mendapatkan data pasien
            Optional<Pasien> optionalPasien = pasienService.findByPhoneNumber(noHP);
            if (optionalPasien.isEmpty()) {
                throw new IllegalStateException("Data pasien tidak ditemukan. Harap registrasi terlebih dahulu.");
            }

            // Ambil norekammedispasien dari objek Pasien
            String norekammedispasien = optionalPasien.get().getNorekammedispasien();

            // Parsing waktu dalam format 24 jam (HH:mm)
            LocalTime time = LocalTime.parse(jam_mulai, DateTimeFormatter.ofPattern("HH:mm"));

            // Buat objek Pendaftaran
            Pendaftaran pendaftaran = new Pendaftaran();
            int newId = pendaftaranRepository.getMaxIdPendaftaran() + 1;

            pendaftaran.setIdPendaftaran(newId);
            pendaftaran.setTglPendaftaran(LocalDate.now());
            pendaftaran.setJamMulai(time);
            pendaftaran.setJamAkhir(LocalTime.parse("23:59"));
            pendaftaran.setIdKlinik(id_klinik);

            // Simpan data ke tabel pendaftaran
            pendaftaranRepository.savePendaftaran(pendaftaran);

            // Simpan data ke tabel pendaftaranpasien
            pendaftaranRepository.savePendaftaranPasien(newId, norekammedispasien);

            return "redirect:/pasien/main";
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing time: " + e.getMessage());
            throw new IllegalArgumentException("Format waktu tidak valid. Harap gunakan format seperti 'HH:mm'.");
        } catch (Exception e) {
            System.err.println("Error saving pendaftaran: " + e.getMessage());
            return "redirect:/pasien/jadwaldokter?error=true"; // Redirect kembali jika terjadi error
        }
    }
}