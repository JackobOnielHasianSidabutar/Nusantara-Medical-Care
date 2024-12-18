package com.example.nmc.Pegawai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class PegawaiService {
    
    @Autowired
    private PegawaiRepository pegawaiRepository;

    public Pegawai login(String username, String password) {
        Optional<Pegawai> pegawai = (Optional<Pegawai>) pegawaiRepository.findByUsername(username);
        try {
            if(pegawai.isPresent() && pegawai.get().getPasswordpegawai().equals(password)) {
                return pegawai.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public Optional<Pegawai> findByUsername(String username) {
        return pegawaiRepository.findByUsername(username);
    }
}
