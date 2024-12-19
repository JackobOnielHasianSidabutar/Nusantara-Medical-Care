package com.example.nmc.Perawat;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nmc.InformasiDasarPasien.InformasiDasarPasien;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PerawatService {
    private final PerawatRepository perawatRepository;
    public List<Map<String, Object>> findAll() {
        return perawatRepository.listPasien();
    }
    public void save(InformasiDasarForm informasi) {
        perawatRepository.save(informasi);
    }
}