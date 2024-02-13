package com.example.AuditTrial.service;

import com.example.AuditTrial.entity.prescription;
import com.example.AuditTrial.repo.prescriptionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PresService {
    @Autowired
    private prescriptionRepo repo;

    public String save(prescription p){
        repo.save(p);

        return "saved";
    }
}
