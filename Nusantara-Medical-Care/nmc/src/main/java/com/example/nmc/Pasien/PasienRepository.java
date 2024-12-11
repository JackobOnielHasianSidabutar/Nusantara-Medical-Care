package com.example.nmc.Pasien;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface PasienRepository {
    Pasien save(Pasien pasien);

    Optional<Pasien> findByNoHpPasien(String noHpPasien);
}
