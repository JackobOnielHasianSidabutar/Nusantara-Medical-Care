package com.example.nmc.Testing;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestingService {

    private final TestingRepository testingRepository;

    public List<Testing> findAll() {
        return testingRepository.findAll();
    }

    public Testing save(Testing testing) {
        return testingRepository.save(testing);
    }
}
