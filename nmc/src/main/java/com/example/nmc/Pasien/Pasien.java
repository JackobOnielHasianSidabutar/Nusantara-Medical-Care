package com.example.nmc.Pasien;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Pasien {

    @Id
    private String norekammedispasien;

    private String namapasien;
    private String nohppasien;
    private String tgllahirpasien;
    private String jeniskelaminpasien;
}
