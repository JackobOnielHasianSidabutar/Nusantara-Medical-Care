package com.example.nmc.Pegawai;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ListPasienService {

    private final ListPasienRepository listPasienRepository;

    public ListPasienService(ListPasienRepository listPasienRepository) {
        this.listPasienRepository = listPasienRepository;
    }

    public List<ListPasienDTO> getListPasienHariIni() {
        // Ambil tanggal hari ini
        String today = LocalDate.now().toString(); // Format: yyyy-MM-dd

        // Panggil repository dengan tanggal hari ini
        return listPasienRepository.findListPasienByTanggal(today);
    }
}

