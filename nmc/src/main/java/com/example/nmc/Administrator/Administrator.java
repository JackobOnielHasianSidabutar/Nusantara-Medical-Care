package com.example.nmc.Administrator;

import lombok.Data;

@Data
public class Administrator {
    private int idAdministrator;
    private int idKlinik;

    public Administrator(int idAdministrator, int idKlinik) {
        this.idAdministrator = idAdministrator;
        this.idKlinik = idKlinik;
    }

    
    
}
