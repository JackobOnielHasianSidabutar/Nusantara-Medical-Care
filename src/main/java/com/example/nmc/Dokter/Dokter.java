package com.example.nmc.Dokter;

import lombok.Data;

@Data
public class Dokter {
    private int idDokter;
    private int idKlinik;
    private String spesialisDokter;
    private String jadwalMulai;
    private String jadwalAkhir;

}
