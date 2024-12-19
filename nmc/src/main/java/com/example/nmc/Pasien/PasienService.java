package com.example.nmc.Pasien;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasienService {

    private final PasienRepository pasienRepository;

    @Autowired
    public PasienService(PasienRepository pasienRepository) {
        this.pasienRepository = pasienRepository;
    }

    public Pasien register(Pasien pasien) throws Exception {
        if (pasienRepository.findByPhoneNumber(pasien.getNohppasien()).isPresent()) {
            throw new Exception("Nomor HP sudah terdaftar");
        }
        try {
            pasienRepository.register(pasien);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pasien;
    }

    public Pasien login(String nohppasien) {
        return pasienRepository.login(nohppasien);
    }

    public Optional<Pasien> findByPhoneNumber(String nohppasien) {
        return pasienRepository.findByPhoneNumber(nohppasien);
    }

    public boolean isPhoneNumberRegistered(String noHP) {
        return pasienRepository.login(noHP) != null;
    }
    
}