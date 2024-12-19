package com.example.nmc.InformasiDasarPasien;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.nmc.Diagnosa.DiagnosaRepository;

@Repository
public class jdbcInformasiDasarPasienRepo implements InformasiDasarPasienRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void mencatatResepObat(InformasiDasarPasien informasi) {
        String sql = "INSERT INTO informasidasarpasien (norekammedispasien, tanggalperiksa, tinggibadan, tekanandarah, beratbadan, suhutubuh, keluhan, resepobat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, informasi.getNoRekamMedisPasien(), informasi.getTanggalPeriksa(), informasi.getTinggiBadan(), 
            informasi.getTekananDarah(), informasi.getBeratBadan(), informasi.getSuhuTubuh(), informasi.getTekananDarah(), informasi.getKeluhan(), informasi.getResepObat());            
            System.out.println("Informasi pasien berhasil disimpan.");
        } catch (Exception e) {
            System.err.println("Error saat menyimpan: " + e.getMessage());
            throw e;
        }
    }
}
