package com.example.nmc.Pasien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcPasienRepository implements PasienRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Pasien save(Pasien pasien) {
        String sql = "INSERT INTO Pasien (noRekamMedisPasien, namaPasien, noHpPasien, ulangTahunPasien, genderPasien) " +
                     "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                pasien.getNoRekamMedisPasien(),
                pasien.getNamaPasien(),
                pasien.getNoHpPasien(),
                pasien.getTglLahirPasien(),
                pasien.getJenisKelaminPasien());
        return pasien;
    }

    @Override
    public Object findByNoHpPasien(String noHpPasien) {
        String sql = "SELECT * FROM Pasien WHERE noHpPasien = ?";
        try {
            Pasien pasien = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pasien.class), noHpPasien);
            return Optional.of(pasien);
        } catch (Exception e) {
            return Optional.empty();
        }       
    }
}