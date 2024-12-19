package com.example.nmc.Perawat;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.nmc.InformasiDasarPasien.InformasiDasarPasien;
import com.example.nmc.Table.PendaftaranPasien;

public interface PerawatRepository {
    List<Map<String, Object>> listPasien();
    void save(InformasiDasarForm informasi);
}
