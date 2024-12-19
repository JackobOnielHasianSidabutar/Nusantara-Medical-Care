package com.example.nmc.Dokter;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nmc.Diagnosa.Diagnosa;
import com.example.nmc.Diagnosa.DiagnosaService;
import com.example.nmc.Diagnosa.jdbcDiagnosaRepository;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/dokter")
public class DokterController {

    private final DiagnosaService diagnosaService;
    private final DokterService dokterService;

    @PostMapping("/main")
    public String dokterMain(@RequestParam String usernameDokter, @RequestParam String passwordDokter, HttpSession session, Model model) {
        model.addAttribute("name", usernameDokter);
        session.setAttribute("username", usernameDokter);
        return "DokterMain"; 
    }

    @PostMapping("/diagnosa")
    public String dokterMain(@RequestParam String diagnosa, HttpSession session, Model model) {
        int pegawaiId= (Integer) session.getAttribute("pegawaiId");
        System.out.println("diagnosa" + diagnosa);

        Optional<Dokter> dokter=dokterService.findByPegawaiId(pegawaiId);
        if(dokter==null){
            return "";
        }

        Diagnosa diagnosaObj= new Diagnosa();
        diagnosaObj.setNamaDiagnosa(diagnosa);
        diagnosaObj.setIdDokter(dokter.get().getIdDokter());

        diagnosaService.mencatatDiagnosa(diagnosaObj);

        return "DokterMain"; 
    }

}
