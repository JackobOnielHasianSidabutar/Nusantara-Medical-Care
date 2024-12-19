package com.example.nmc.Administrator;

import java.util.List;

import com.example.nmc.DTO.DaftarDokter;
import com.example.nmc.DTO.PendaftaranPasien;
import com.example.nmc.Transaksi.Transaksi;

public interface AdministratorRepository {
    void mencatatTransaksi(Transaksi transaksi) throws Exception;
    List<PendaftaranPasien> showAll();
    List<DaftarDokter> showDokter();
}
