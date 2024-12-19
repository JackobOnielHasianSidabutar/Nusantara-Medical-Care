package com.example.nmc.Table;

import lombok.Data;

@Data
public class PendaftaranPasien {
    private int idPendaftaran;
    private String noRekamMedisPasien;

    public PendaftaranPasien(int idPendaftaran, String noRekamMedisPasien) {
        this.idPendaftaran = idPendaftaran;
        this.noRekamMedisPasien = noRekamMedisPasien;
    }

}
