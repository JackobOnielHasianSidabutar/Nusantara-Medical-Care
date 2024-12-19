package com.example.nmc.InformasiDasarPasien;

import lombok.Data;

@Data
public class InformasiDasarPasien {
    private int idInformasi;
    private String noRekamMedisPasien;
    private String tanggalPeriksa;
    private String tinggiBadan;
    private String tekananDarah;
    private String beratBadan;
    private String suhuTubuh;
    private String keluhan;
    private String hasilLab;
    private String resepObat;
}