package com.example.nmc.Pendaftaran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryPendaftaran implements PendaftaranRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepositoryPendaftaran(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getMaxIdPendaftaran() {
        String sql = "SELECT COALESCE(MAX(idpendaftaran), 0) FROM pendaftaran";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    @Override
    public void savePendaftaran(Pendaftaran pendaftaran) {
        String sqlGetAdmin = "SELECT idadministrator FROM administrator LIMIT 1";
        Integer idAdministrator = jdbcTemplate.queryForObject(sqlGetAdmin, Integer.class);
        String sql = "INSERT INTO pendaftaran (idpendaftaran, tglpendaftaran, jammulai, jamakhir, idklinik, idadministrator) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                pendaftaran.getIdPendaftaran(),
                java.sql.Date.valueOf(pendaftaran.getTglPendaftaran()), 
                pendaftaran.getJamMulai(),       
                pendaftaran.getJamAkhir(),
                pendaftaran.getIdKlinik(),
                idAdministrator
        );
    }
    @Override
    public void savePendaftaranPasien(int idPendaftaran, String norekammedispasien) {
        String sql = "INSERT INTO pendaftaranpasien (idpendaftaran, norekammedispasien) VALUES (?, ?)";
        jdbcTemplate.update(sql, idPendaftaran, norekammedispasien);
    }
    @Override
    public String findNorekammedisByNoHP(String nohppasien) {
        String sql = "SELECT norekammedispasien FROM pasien WHERE nohppasien = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nohppasien}, String.class);
    }
}

