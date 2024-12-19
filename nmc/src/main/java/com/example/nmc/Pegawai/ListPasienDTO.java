package com.example.nmc.Pegawai;

public class ListPasienDTO {
    private String norekammedispasien;
    private String namapasien;
    private String tglpendaftaran;
    private String idKlinik;
    private String statuspendaftaran;

    // Constructor
    public ListPasienDTO(String norekammedispasien, String namapasien, String tglpendaftaran, String idKlinik, String statuspendaftaran) {
        this.norekammedispasien = norekammedispasien;
        this.namapasien = namapasien;
        this.tglpendaftaran = tglpendaftaran;
        this.idKlinik = idKlinik;
        this.statuspendaftaran = statuspendaftaran;
    }

    // Getters and Setters
    public String getNorekammedispasien() {
        return norekammedispasien;
    }

    public void setNorekammedispasien(String norekammedispasien) {
        this.norekammedispasien = norekammedispasien;
    }

    public String getNamapasien() {
        return namapasien;
    }

    public void setNamapasien(String namapasien) {
        this.namapasien = namapasien;
    }

    public String getTglpendaftaran() {
        return tglpendaftaran;
    }

    public void setTglpendaftaran(String tglpendaftaran) {
        this.tglpendaftaran = tglpendaftaran;
    }

    public String getIdKlinik() {
        return idKlinik;
    }

    public void setIdKlinik(String idKlinik) {
        this.idKlinik = idKlinik;
    }

    public String getStatuspendaftaran(){
        return statuspendaftaran;
    }

    public void setStatuspendaftaran(String statuspendaftaran){
        this.statuspendaftaran = statuspendaftaran;
    }
}

