package com.example.nmc.Pasien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PasienService {

    @Autowired
    private PasienRepository pasienRepository;

    public Pasien register(String namaPasien,  LocalDate tglLahirPasien, String jenisKelaminPasien, String noHpPasien) {
        Pasien pasien = new Pasien(namaPasien, tglLahirPasien, jenisKelaminPasien, noHpPasien);
        pasien.setNamaPasien(namaPasien);
        pasien.setTglLahirPasien(tglLahirPasien);
        pasien.setJenisKelaminPasien(jenisKelaminPasien);
        pasien.setNoHpPasien(noHpPasien);

        return pasienRepository.save(pasien);
    }
}
