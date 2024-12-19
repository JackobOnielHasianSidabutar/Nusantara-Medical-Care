package com.example.nmc.Diagnosa;

import org.springframework.stereotype.Service;

@Service
public class DiagnosaService {
    private final DiagnosaRepository diagnosaRepository;
    public  DiagnosaService(DiagnosaRepository diagnosaRepository){
        this.diagnosaRepository= diagnosaRepository;
    }
    public void mencatatDiagnosa(Diagnosa diagnosa){
        diagnosaRepository.mencatatDiagnosa(diagnosa);
    }
}