package com.example.nmc.Pegawai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

public class JdbcRepositoryPegawai implements PegawaiRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void login(String username, String password) {
        // String sql = "SELECT * FROM Pegawai WHERE username = ?";
    }

    @Override
    public Object findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
        String sql = SELECT * FROM 
    }

    
}
