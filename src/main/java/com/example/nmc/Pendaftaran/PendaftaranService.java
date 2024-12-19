package com.example.nmc.Pendaftaran;

import org.springframework.stereotype.Service;

@Service
public class PendaftaranService {

    private final PendaftaranRepository pendaftaranRepository;

    public PendaftaranService(PendaftaranRepository pendaftaranRepository) {
        this.pendaftaranRepository = pendaftaranRepository;
    }

    public void savePendaftaran(Pendaftaran pendaftaran, String norekammedispasien) {
        // Gunakan metode pada interface
        int maxId = pendaftaranRepository.getMaxIdPendaftaran();
        pendaftaran.setIdPendaftaran(maxId + 1); // Tetapkan ID baru
        pendaftaranRepository.savePendaftaran(pendaftaran);
        pendaftaranRepository.savePendaftaranPasien(pendaftaran.getIdPendaftaran(), norekammedispasien);
    }
}
