package com.example.nmc.Transaksi;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaksi {
    private int idTransaksi;
    private LocalDate tanggalTransaksi;
    private double totalTransaksi;
    private String jenisTransaksi;
}
