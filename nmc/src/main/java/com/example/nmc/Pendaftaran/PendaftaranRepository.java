package com.example.nmc.Pendaftaran;

public interface PendaftaranRepository {
    int getMaxIdPendaftaran();
    String findNorekammedisByNoHP(String nohppasien);
    void savePendaftaran(Pendaftaran pendaftaran);
    void savePendaftaranPasien(String norekammedispasien, int idPendaftaran);
}