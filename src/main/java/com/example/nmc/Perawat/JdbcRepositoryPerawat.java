package com.example.nmc.Perawat;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.nmc.InformasiDasarPasien.InformasiDasarPasien;
import com.example.nmc.Pasien.Pasien;
import com.example.nmc.Table.PendaftaranPasien;
import com.example.nmc.Testing.Testing;

@Repository
public class JdbcRepositoryPerawat implements PerawatRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> listPasien() {
        String sql = "select p.norekammedispasien, p.namapasien, d.tglpendaftaran from pasien p left join pasienpendaftaran pp on p.norekammedispasien=pp.norekammedispasien left join pendaftaran d on d.idpendaftaran=pp.idpendaftaran";
        try {
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            System.out.println("Error when get testing: " + e.getMessage());

            return List.of();
        }
    }

    @Override
    public void save(InformasiDasarForm informasi){
        String sql="INSERT INTO informasidasarpasien (norekammedispasien, idperawat, tanggalperiksa, tinggibadan, tekanandarah, beratbadan, suhutubuh, keluhan, hasillab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            jdbcTemplate.update(sql, informasi.getNoRekamMedisPasien(), informasi.getIdPerawat(), sdf.parse(informasi.getTanggalPeriksa()), informasi.getTinggiBadan(), informasi.getTekananDarah(), informasi.getBeratBadan(), informasi.getSuhuTubuh(), informasi.getKeluhan(), informasi.getHasilLab());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    }
    
    
}
