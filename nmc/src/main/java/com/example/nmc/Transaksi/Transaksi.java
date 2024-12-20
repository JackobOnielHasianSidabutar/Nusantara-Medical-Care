package com.example.nmc.Transaksi;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaksi {
    private LocalDate tanggalTransaksi;
    private double totalTransaksi;
    private String jenisTransaksi;

    public Transaksi(LocalDate tanggalTransaksi, double totalTransaksi, String jenisTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
        this.totalTransaksi = totalTransaksi;
        this.jenisTransaksi = jenisTransaksi;
    }
    
}
