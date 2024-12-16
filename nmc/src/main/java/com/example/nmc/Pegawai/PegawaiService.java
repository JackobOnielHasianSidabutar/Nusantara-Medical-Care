package com.example.nmc.Pegawai;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PegawaiService{

    private final PegawaiRepository pegawaiRepository;

    public Pegawai login(String username, String password) {
        Optional<Pegawai> pegawai = pegawaiRepository.findByUsername(username);

        if (pegawai.isPresent() && pegawai.get().getPasswordpegawai().equals(password)) {
            return pegawai.get(); // Login berhasil
        }
        return null;
    }

    public Optional<Pegawai> findByUsername(String username) {
        return pegawaiRepository.findByUsername(username);
    }

}
