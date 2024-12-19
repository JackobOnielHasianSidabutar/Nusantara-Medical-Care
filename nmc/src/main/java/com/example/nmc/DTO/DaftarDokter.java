package com.example.nmc.DTO;

import java.time.LocalTime;

import lombok.Data;

@Data
public class DaftarDokter {
    private int iddokter;
    private String namapegawai;
    private String spesialisdokter;
    private LocalTime jadwalmulai;
    private LocalTime jadwalakhir;
    
    public DaftarDokter(int iddokter, String namapegawai, String spesialisdokter, LocalTime jadwalmulai,
            LocalTime jadwalakhir) {
        this.iddokter = iddokter;
        this.namapegawai = namapegawai;
        this.spesialisdokter = spesialisdokter;
        this.jadwalmulai = jadwalmulai;
        this.jadwalakhir = jadwalakhir;
    }

    
}
