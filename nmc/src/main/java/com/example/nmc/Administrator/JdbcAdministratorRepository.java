package com.example.nmc.Administrator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.nmc.Dokter.DaftarDokter;
import com.example.nmc.Pendaftaran.PendaftaranPasienDTO;
import com.example.nmc.Transaksi.Transaksi;

@Repository
public class JdbcAdministratorRepository implements AdministratorRepository {
   
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void mencatatTransaksi(Transaksi transaksi) throws Exception {
        String sql = "INSERT INTO Transaksi (tanggalTransaksi, totalTransaksi, jenisTransaksi) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, transaksi.getTanggalTransaksi(), transaksi.getTanggalTransaksi(), transaksi.getJenisTransaksi());
    }
    @Override
    public List<PendaftaranPasienDTO> showAll() {
        String sql = "SELECT pasien.norekammedispasien, namapasien, tglpendaftaran, statuspendaftaran FROM pasien INNER JOIN pasienpendaftaran ON pasien.norekammedispasien = pasienpendaftaran.norekammedispasien INNER JOIN pendaftaran ON pendaftaran.idpendaftaran = pasienpendaftaran.idpendaftaran";
        return jdbcTemplate.query(sql, this::mapRowToPendaftaran);
    }
    private PendaftaranPasienDTO mapRowToPendaftaran(ResultSet resultSet, int rowNum) throws SQLException {
        return new PendaftaranPasienDTO(
            resultSet.getString("norekammedispasien"),
            resultSet.getString("namapasien"), 
            resultSet.getObject("tglpendaftaran", LocalDate.class), 
            resultSet.getString("statuspendaftaran")
            );
    }
    @Override
    public List<DaftarDokter> showDokter() {
        String sql = "SELECT iddokter, namapegawai, spesialisdokter, jadwalmulai, jadwalakhir FROM dokter INNER JOIN pegawai ON iddokter = idpegawai INNER JOIN poliklinik ON dokter.idklinik = poliklinik.idklinik";
        return jdbcTemplate.query(sql, this::mapRowToDaftarDokter);
    }
    private DaftarDokter mapRowToDaftarDokter(ResultSet resultSet, int rowNum) throws SQLException {
        return new DaftarDokter(
            resultSet.getInt("iddokter"), 
            resultSet.getString("namapegawai"), 
            resultSet.getString("spesialisdokter"), 
            resultSet.getObject("jadwalmulai", LocalTime.class), 
            resultSet.getObject("jadwalakhir", LocalTime.class)
            );
    }
    
}