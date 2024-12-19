package com.example.nmc.Dokter;

import lombok.Data;

@Data
public class Dokter {
    private String idDokter;
    private String spesialisDokter;
    private String idKlinik;

    public Dokter(String idDokter, String spesialisDokter, String idKlinik) {
        this.idDokter = idDokter;
        this.spesialisDokter = spesialisDokter;
        this.idKlinik = idKlinik;
    }

}
