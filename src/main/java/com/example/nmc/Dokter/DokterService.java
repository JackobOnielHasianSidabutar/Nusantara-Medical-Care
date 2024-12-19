package com.example.nmc.Dokter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DokterService {
    private final DokterRepository dokterRepository;

    Optional<Dokter> findByPegawaiId(int pegawaiId){
        return dokterRepository.findByPegawaiId(pegawaiId);
    }
}
