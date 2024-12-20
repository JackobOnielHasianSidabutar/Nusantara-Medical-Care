package com.example.nmc.Pasien;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryPasien implements PasienRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Pasien login(String nohppasien) {
        String sql = "SELECT * FROM Pasien WHERE nohppasien = ?";
        try {
            return jdbcTemplate.queryForObject(sql, pasienRowMapper, nohppasien);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<Pasien> findByPhoneNumber(String nohppasien) {
        String sql = "SELECT * FROM Pasien WHERE nohppasien = ?";
        try {
            Pasien pasien = jdbcTemplate.queryForObject(sql, pasienRowMapper, nohppasien);
            return Optional.of(pasien);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private RowMapper<Pasien> pasienRowMapper = (rs, rowNum) -> {
        Pasien pasien = new Pasien();
        pasien.setNorekammedispasien(rs.getString("norekammedispasien")); 
        pasien.setNamapasien(rs.getString("namapasien"));  
        pasien.setNohppasien(rs.getString("nohppasien"));
        pasien.setTgllahirpasien(rs.getString("tgllahirpasien"));
        pasien.setJeniskelaminpasien(rs.getString("jeniskelaminpasien"));
        return pasien;
    };

    @Override
    public void register(Pasien pasien) throws Exception {
        String code = "NMC-2024";
        String norekammedispasien = code + "-" + System.currentTimeMillis();
        pasien.setNorekammedispasien(norekammedispasien);

        if (pasien.getNamapasien() == null || pasien.getNamapasien().isEmpty()) {
            throw new IllegalArgumentException("Nama pasien tidak boleh kosong.");
        }
        if (pasien.getTgllahirpasien() == null || pasien.getTgllahirpasien().isEmpty()) {
            throw new IllegalArgumentException("Tanggal lahir pasien tidak boleh kosong.");
        }

        Date tgllahir = Date.valueOf(pasien.getTgllahirpasien());

        String sql = "INSERT INTO pasien (norekammedispasien, namapasien, tgllahirpasien, jeniskelaminpasien, nohppasien) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, norekammedispasien, pasien.getNamapasien(), tgllahir, pasien.getJeniskelaminpasien(), pasien.getNohppasien());
            System.out.println("Data pasien berhasil disimpan.");
        } catch (Exception e) {
            System.err.println("Error saat menyimpan data pasien: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<String> findNorekammedisByNoHP(String nohppasien) {
        String sql = "SELECT norekammedispasien FROM pasien WHERE nohppasien = ?";
        try {
            String norekammedis = jdbcTemplate.queryForObject(sql, new Object[]{nohppasien}, String.class);
            return Optional.ofNullable(norekammedis);
        } catch (Exception e) {
            return Optional.empty(); // Jika tidak ditemukan
        }
    }

    @Override
    public Optional<Pasien> findById(String id) {
        return Optional.empty();
    }

    

}
