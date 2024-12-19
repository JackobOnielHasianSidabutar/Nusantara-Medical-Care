package com.example.nmc.Pendaftaran;
import java.io.Serializable;

import lombok.Data;
@Data
public class PasienPendaftaran implements Serializable {
    private int idPendaftaran;
    private String noRekamMedisPasien;
    public PasienPendaftaran(int idPendaftaran, String noRekamMedisPasien) {
        this.idPendaftaran = idPendaftaran;
        this.noRekamMedisPasien = noRekamMedisPasien;
    }
}
