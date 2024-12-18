package com.example.nmc.Pegawai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRepositoryPegawai implements PegawaiRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void login(String username, String password) {
        String sql = "SELECT * FROM Pegawai WHERE username = ?";
    }

    @Override
    public Optional<Pegawai> findByUsername(String username) {
        String sql = "SELECT usernamepegawai FROM pegawai  WHERE usernamepegawai = ?";
        // return sql;
        return null;
    }
    
    

    
}
