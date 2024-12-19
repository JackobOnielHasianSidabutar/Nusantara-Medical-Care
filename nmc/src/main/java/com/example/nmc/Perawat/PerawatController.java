package com.example.nmc.Perawat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.nmc.Testing.Testing;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/perawat")
public class PerawatController {

    private final PerawatService perawatService;

    @GetMapping("/main")
    public String dokterMain(HttpSession session, Model model) {
        List<Map<String, Object>> listPasien= perawatService.findAll();
        // model.addAttribute("name", usernamePerawat);
        // session.setAttribute("username", usernamePerawat);
        model.addAttribute("listPasien", listPasien);
        System.out.println("list: "+ perawatService.findAll());
        return "PerawatMain"; 
    }

    @PostMapping("upload")
    public String save(
            @RequestParam("norekammedispasien") String norekammedispasien,
            @RequestParam("tanggalperiksa") String tanggalperiksa,
            @RequestParam("tinggibadan") String tinggibadan,
            @RequestParam("beratbadan") String beratbadan,
            @RequestParam("suhubadan") String suhubadan,
            @RequestParam("tekanandarah") String tekanandarah,
            @RequestParam("keluhan") String keluhan,
            @RequestParam("hasilLab") MultipartFile hasilLab
    ) {
        try {
            // check if directory exists
            File dir = new File(System.getProperty("user.dir") + "/Uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String destination = System.getProperty("user.dir") + "/Uploads" + File.separator + hasilLab.getOriginalFilename();
            hasilLab.transferTo(new java.io.File(destination));

            InformasiDasarForm informasiDasar = new InformasiDasarForm();
            informasiDasar.setNoRekamMedisPasien(norekammedispasien);
            informasiDasar.setIdPerawat(4);
            informasiDasar.setTanggalPeriksa(tanggalperiksa);
            informasiDasar.setTinggiBadan(Integer.parseInt(tinggibadan));
            informasiDasar.setBeratBadan(Integer.parseInt(beratbadan));
            informasiDasar.setSuhuTubuh(Integer.parseInt(suhubadan));
            informasiDasar.setTekananDarah(tekanandarah);
            informasiDasar.setKeluhan(keluhan);
            informasiDasar.setHasilLab(destination);

            perawatService.save(informasiDasar);
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Error when save testing: " + e.getMessage());
        }

        return "redirect:/perawat/main";
    }
}
