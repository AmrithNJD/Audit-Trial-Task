package com.example.AuditTrial.repo;

import com.example.AuditTrial.entity.prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;


public interface prescriptionRepo extends RevisionRepository<prescription,Integer,Integer>, JpaRepository<prescription,Integer> {
}
