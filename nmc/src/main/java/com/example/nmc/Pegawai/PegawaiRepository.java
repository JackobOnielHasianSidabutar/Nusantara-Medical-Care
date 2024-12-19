package com.example.nmc.Pegawai;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiRepository {
    Pegawai login(String username, String password);
    Optional<Pegawai> findByUsername (String username);
}
