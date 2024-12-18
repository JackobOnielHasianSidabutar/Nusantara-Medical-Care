package com.example.nmc.Pegawai;

import java.util.Optional;

public interface PegawaiRepository {
    Pegawai login(String username, String password);
    Optional<Pegawai> findByUsername (String username);
}
