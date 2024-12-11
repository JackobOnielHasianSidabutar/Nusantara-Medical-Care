package com.example.nmc.Pegawai;

import java.util.Optional;

public interface PegawaiRepository {
    void login(String username, String password);
    Optional<Pegawai> findByUsername (String username);
}
