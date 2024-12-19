package com.example.nmc.Testing;

import java.util.List;

public interface TestingRepository {

    List<Testing> findAll();

    Testing save(Testing testing);
}
