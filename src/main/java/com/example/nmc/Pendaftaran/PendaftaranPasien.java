package com.example.nmc.Pendaftaran;

import lombok.Data;
import java.io.Serializable;


@Data
public class PendaftaranPasien implements Serializable {
    private int idPendaftaran;
    private String noRekamMedisPasien;

    public PendaftaranPasien(int idPendaftaran, String noRekamMedisPasien) {
        this.idPendaftaran = idPendaftaran;
        this.noRekamMedisPasien = noRekamMedisPasien;
    }
}
