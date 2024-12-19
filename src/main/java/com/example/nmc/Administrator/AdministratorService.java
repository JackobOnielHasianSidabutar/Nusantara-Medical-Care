package com.example.nmc.Administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nmc.Dokter.Dokter;
import com.example.nmc.Transaksi.Transaksi;

@Service
public class AdministratorService {
    
    @Autowired
    private AdministratorRepository repo;

    public boolean transaksi(Transaksi transaksi) {
        try {
            this.repo.mencatatTransaksi(transaksi);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
