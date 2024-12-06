package com.example.nmc.Pegawai;

import lombok.Data;

@Data
public class Pegawai {
    private int idPegawai;
    private String username;
    private String passwordPegawai;
    private String namaPegawai;

    public Pegawai(int idPegawai, String username, String passwordPegawai, String namaPegawai) {
        this.idPegawai = idPegawai;
        this.username = username;
        this.passwordPegawai = passwordPegawai;
        this.namaPegawai = namaPegawai;
    }

}
