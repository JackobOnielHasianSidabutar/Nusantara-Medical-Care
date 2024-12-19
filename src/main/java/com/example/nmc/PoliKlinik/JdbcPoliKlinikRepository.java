package com.example.nmc.PoliKlinik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPoliKlinikRepository implements PoliKlinikRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper untuk memetakan hasil query ke objek PoliKlinik
    private RowMapper<PoliKlinik> poliKlinikRowMapper = (rs, rowNum) -> {
        PoliKlinik poliKlinik = new PoliKlinik();
        poliKlinik.setIdKlinik(rs.getInt("idklinik"));
        poliKlinik.setNamaKlinik(rs.getString("namaklinik"));
        return poliKlinik;
    };

    @Override
    public List<PoliKlinik> getAllPoliKlinik() {
        String sql = "SELECT idklinik, namaklinik FROM poliklinik";
        return jdbcTemplate.query(sql, poliKlinikRowMapper);
    }
}
