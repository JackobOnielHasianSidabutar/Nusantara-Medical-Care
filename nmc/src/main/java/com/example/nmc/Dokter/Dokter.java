package com.example.nmc.Dokter;

import lombok.Data;

@Data
public class Dokter {
    public String name;
    public String password;

    public Dokter(String name, String password){
        this.name = name;
        this.password = password;
    }
}
