package com.example.nmc.Administrator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.nmc.Dokter.DaftarDokter;
import com.example.nmc.Pendaftaran.PendaftaranPasienDTO;
import com.example.nmc.Transaksi.Transaksi;

@Repository
public interface AdministratorRepository {
    void mencatatTransaksi(Transaksi transaksi) throws Exception;
    List<PendaftaranPasienDTO> showAll();
    List<DaftarDokter> showDokter();
}
