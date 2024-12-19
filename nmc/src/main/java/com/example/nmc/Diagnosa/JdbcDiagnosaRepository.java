package com.example.nmc.Diagnosa;
import java.sql.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.nmc.Diagnosa.DiagnosaRepository;
@Repository
public class JdbcDiagnosaRepository implements DiagnosaRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void mencatatDiagnosa(Diagnosa diagnosa) {
        String sql = "INSERT INTO diagnosa (namadiagnosa, norekammedispasien, iddokter) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, diagnosa.getNamaDiagnosa(), "-", diagnosa.getIdDokter());            
            System.out.println("Diagnosa berhasil disimpan.");
        } catch (Exception e) {
            System.err.println("Error saat menyimpan diagnosa: " + e.getMessage());
            throw e;
        }
    }
}