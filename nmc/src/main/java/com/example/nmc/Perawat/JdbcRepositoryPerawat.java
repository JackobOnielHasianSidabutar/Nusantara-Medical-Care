package com.example.nmc.Perawat;

import java.util.List;

import com.example.nmc.Table.PendaftaranPasien;

public class JdbcRepositoryPerawat implements PerawatRepository {

    @Override
    public List<PendaftaranPasien> listPasien() {
        String sql = "SELECT norekammedispasien, namapasien, tglpendaftaran FROM pasien INNER JOIN pendaftaranpasien ON pasien.norekammedispasien = pendaftaranpasien.norekammedispasien INNER JOIN pendaftaran ON pendaftaran.idpendaftaran = pendaftaranpasien.idpendaftaran";
        return null;//sementara
    }
    
    
}
