package com.example.nmc.Perawat;

import lombok.Data;

@Data
public class InformasiDasarForm {
    private int idInformasi;
    private String noRekamMedisPasien;
    private int idPerawat;
    private String tanggalPeriksa;
    private int tinggiBadan;
    private String tekananDarah;
    private int beratBadan;
    private int suhuTubuh;
    private String keluhan;
    private String hasilLab;

}