package com.example.nmc.Dokter;

import java.util.Optional;

public interface DokterRepository {
    Optional<Dokter> findByPegawaiId(int pegawaiId);
}
