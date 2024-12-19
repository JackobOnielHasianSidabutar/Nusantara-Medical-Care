package com.example.nmc.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PendaftaranPasien {
    private String norekammedispasien;
    private String namapasien;
    private LocalDate tglpendaftaran;
    private String statuspendaftaran;
    
    public PendaftaranPasien(String norekammedispasien, String namapasien, LocalDate tglpendaftaran,
            String statuspendaftarn) {
        this.norekammedispasien = norekammedispasien;
        this.namapasien = namapasien;
        this.tglpendaftaran = tglpendaftaran;
        this.statuspendaftaran = statuspendaftarn;
    }

    
}
