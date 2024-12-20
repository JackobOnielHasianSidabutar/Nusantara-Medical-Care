package com.example.nmc.Pasien;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface PasienRepository {
    Pasien login(String nohppasien);
    void register(Pasien pasien) throws Exception;
    Optional<Pasien> findByPhoneNumber (String nohppasien);
    Optional<String> findNorekammedisByNoHP(String nohppasien);
    Optional<Pasien> findById(String id);
}
