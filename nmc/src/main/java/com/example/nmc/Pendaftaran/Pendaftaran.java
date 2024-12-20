package com.example.nmc.Pendaftaran;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Pendaftaran {
    private int idPendaftaran;
    private LocalDate tglPendaftaran;
    private String statusPendaftaran = "Online";
    private LocalTime jamMulai;
    private LocalTime jamAkhir;
    private int idKlinik;
    private int idAdministrator;

}
