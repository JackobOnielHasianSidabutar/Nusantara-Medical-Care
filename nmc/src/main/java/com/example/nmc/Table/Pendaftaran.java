package com.example.nmc.Table;

import lombok.Data;

@Data
public class Pendaftaran {
    private int idPenddaftaran;
    private String tglPendaftaran;
    private String jamMulai;
    private String jamAkhir;
    private int idKlinik;
    private int idAdministrator;
}
