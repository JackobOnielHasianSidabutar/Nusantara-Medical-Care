package com.example.nmc.Pegawai;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListPasienRepository {

    private final JdbcTemplate jdbcTemplate;

    public ListPasienRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ListPasienDTO> findListPasienByTanggal(String tanggal) {
        String sql = """
            SELECT p.norekammedispasien, p.namapasien, d.tglpendaftaran, k.idKlinik, d.statuspendaftaran FROM pasien p INNER JOIN pasienpendaftaran pp ON p.norekammedispasien = pp.norekammedispasien INNER JOIN pendaftaran d ON d.idpendaftaran = pp.idpendaftaran INNER JOIN poliklinik k ON k.idklinik = d.idklinik WHERE d.tglpendaftaran = CAST(? AS date)""";
    
        return jdbcTemplate.query(
            sql,
            (rs, rowNum) -> new ListPasienDTO(
                rs.getString("norekammedispasien"),
                rs.getString("namapasien"),
                rs.getString("tglpendaftaran"),
                rs.getString("idKlinik"),
                rs.getString("statuspendaftaran")
            ),
            tanggal
        );
    }
    
}
