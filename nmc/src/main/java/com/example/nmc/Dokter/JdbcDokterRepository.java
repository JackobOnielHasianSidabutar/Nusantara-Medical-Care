package com.example.nmc.Dokter;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.nmc.Diagnosa.DiagnosaRepository;
import com.example.nmc.Pasien.Pasien;

@Repository
public class JdbcDokterRepository implements DokterRepository{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Dokter> findByPegawaiId(int pegawaiId) {
        // TODO Auto-generated method stub
        String sql="SELECT * FROM dokter WHERE idpegawai = ?";
        try{
            Dokter dokter = jdbcTemplate.queryForObject(sql, dokterRowMapper, pegawaiId);

            return Optional.of(dokter);
        } catch (Exception e){
            System.out.println(e.getMessage());

            return Optional.empty();
        }
    }

    private RowMapper<Dokter> dokterRowMapper = (rs, rowNum) -> {
        Dokter dokter = new Dokter();
        dokter.setIdDokter(rs.getInt("iddokter"));
        dokter.setIdPegawai(rs.getInt("idpegawai"));  
        dokter.setIdKlinik((rs.getInt("idklinik")));
        dokter.setSpesialisDokter(rs.getString("spesialisdokter"));
        dokter.setJadwalMulai(rs.getString("jadwalmulai"));
        dokter.setJadwalAkhir(rs.getString("jadwalakhir"));
        return dokter;
    };
}
