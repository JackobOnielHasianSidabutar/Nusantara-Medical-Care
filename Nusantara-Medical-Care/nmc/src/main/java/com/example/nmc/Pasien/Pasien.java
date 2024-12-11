package com.example.nmc.Pasien;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pasien {
    private String noRekamMedisPasien;
    private String namaPasien;
    private String noHpPasien;
    private LocalDate tglLahirPasien;
    private String jenisKelaminPasien;

    public Pasien(String noRekamMedisPasien, String namaPasien, String noHpPasien, LocalDate tglLahirPasien, String jenisKelaminPasien) {
        this.noRekamMedisPasien = noRekamMedisPasien;
        this.namaPasien = namaPasien;
        this.noHpPasien = noHpPasien;
        this.tglLahirPasien = tglLahirPasien;
        this.jenisKelaminPasien = jenisKelaminPasien;
    }

    public Pasien(String namaPasien, LocalDate tglLahirPasien, String jenisKelaminPasien, String noHpPasien) {
        this.namaPasien = namaPasien;
        this.noHpPasien = noHpPasien;
        this.tglLahirPasien = tglLahirPasien;
        this.jenisKelaminPasien = jenisKelaminPasien;
    }

}
