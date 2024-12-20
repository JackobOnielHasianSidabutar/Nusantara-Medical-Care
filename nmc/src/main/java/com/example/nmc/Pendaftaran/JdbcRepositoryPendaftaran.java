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
        String sql = "INSERT INTO pendaftaran (idpendaftaran, tglpendaftaran, statuspendaftaran, jammulai, jamakhir) "
                + "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                pendaftaran.getIdPendaftaran(),
                java.sql.Date.valueOf(pendaftaran.getTglPendaftaran()),
                pendaftaran.getStatusPendaftaran(),
                pendaftaran.getJamMulai(),       
                pendaftaran.getJamAkhir()
        );
    }
    @Override
    public void savePendaftaranPasien(String norekammedispasien, int idPendaftaran) {
        String sql = "INSERT INTO pasienpendaftaran (norekammedispasien, idpendaftaran) VALUES (?, ?)";
        jdbcTemplate.update(sql, norekammedispasien, idPendaftaran);
    }
    @Override
    public String findNorekammedisByNoHP(String nohppasien) {
        String sql = "SELECT norekammedispasien FROM pasien WHERE nohppasien = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nohppasien}, String.class);
    }
}

