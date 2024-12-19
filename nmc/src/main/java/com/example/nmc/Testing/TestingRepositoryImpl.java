package com.example.nmc.Testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestingRepositoryImpl implements TestingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Testing> findAll() {
        String sql = "SELECT * FROM Testing";

        try {
            return jdbcTemplate.queryForList(sql, Testing.class);
        } catch (Exception e) {
            System.out.println("Error when get testing: " + e.getMessage());

            return List.of();
        }
    }

    @Override
    public Testing save(Testing testing) {

        String sql = "INSERT INTO Testing (filename, path) VALUES (?, ?)";

        try {
            jdbcTemplate.update(sql, testing.getFilename(), testing.getPath());

            return testing;
        } catch (Exception e) {
            System.out.println("Error when save testing: " + e.getMessage());
        }

        return null;
    }
}
