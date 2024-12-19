package com.example.nmc.Pendaftaran;

import org.springframework.stereotype.Repository;

@Repository
public interface PendaftaranRepository {
    int getMaxIdPendaftaran();
    String findNorekammedisByNoHP(String nohppasien);
    void savePendaftaran(Pendaftaran pendaftaran);
    void savePendaftaranPasien(int idPendaftaran, String norekammedispasien);
}