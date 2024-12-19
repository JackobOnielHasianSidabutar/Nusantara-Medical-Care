package com.example.nmc.Pegawai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryPegawai implements PegawaiRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Pegawai login(String username, String password) {
        String sql = "SELECT * FROM Pegawai WHERE username = ? AND passwordpegawai = ?";
        try {
            return jdbcTemplate.queryForObject(sql, pegawaiRowMapper, username, password);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<Pegawai> findByUsername(String username) {
        String sql = "SELECT * FROM Pegawai WHERE usernamepegawai = ?";
        try {
            Pegawai pegawai = jdbcTemplate.queryForObject(sql, pegawaiRowMapper, username);
            return Optional.of(pegawai);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private RowMapper<Pegawai> pegawaiRowMapper = (rs, rowNum) -> {
        Pegawai pegawai = new Pegawai();
        pegawai.setIdpegawai(rs.getInt("idpegawai")); 
        pegawai.setUsernamepegawai(rs.getString("usernamepegawai"));  
        pegawai.setPasswordpegawai(rs.getString("passwordpegawai"));
        pegawai.setNamapegawai(rs.getString("namapegawai"));
        return pegawai;
    };
}