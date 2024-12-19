package com.example.nmc.Transaksi;

import lombok.Data;

@Data
public class Transaksi {
    private String idTransaksi;
    private String tanggalTransaksi;
    private double totalTransaksi;
    private String jenisTransaksi;

    public Transaksi(String idTransaksi, String tanggalTransaksi, double totalTransaksi, String jenisTransaksi) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.totalTransaksi = totalTransaksi;
        this.jenisTransaksi = jenisTransaksi;
    }
    
}
