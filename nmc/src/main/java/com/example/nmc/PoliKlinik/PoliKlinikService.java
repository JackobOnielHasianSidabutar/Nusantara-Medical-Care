package com.example.nmc.PoliKlinik;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliKlinikService {

    private final PoliKlinikRepository poliKlinikRepository;

    public PoliKlinikService(PoliKlinikRepository poliKlinikRepository) {
        this.poliKlinikRepository = poliKlinikRepository;
    }

    public List<PoliKlinik> getAllPoliKlinik() {
        return poliKlinikRepository.getAllPoliKlinik();
    }
    
}

