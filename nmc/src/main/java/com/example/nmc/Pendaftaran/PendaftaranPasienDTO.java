package com.example.nmc.Pendaftaran;
import java.time.LocalDate;
import lombok.Data;
@Data
public class PendaftaranPasienDTO {
    private String norekammedispasien;
    private String namapasien;
    private LocalDate tglpendaftaran;
    private String statuspendaftaran;
    
    public PendaftaranPasienDTO(String norekammedispasien, String namapasien, LocalDate tglpendaftaran,
            String statuspendaftarn) {
        this.norekammedispasien = norekammedispasien;
        this.namapasien = namapasien;
        this.tglpendaftaran = tglpendaftaran;
        this.statuspendaftaran = statuspendaftarn;
    }
    
}