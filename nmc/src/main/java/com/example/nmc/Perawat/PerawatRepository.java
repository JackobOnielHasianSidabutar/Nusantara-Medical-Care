package com.example.nmc.Perawat;

import java.util.List;
import java.util.Optional;

import com.example.nmc.Table.PendaftaranPasien;

public interface PerawatRepository {
    List<PendaftaranPasien> listPasien();
}
