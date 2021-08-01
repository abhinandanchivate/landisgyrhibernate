package com.landisgyr.emplmngt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landisgyr.emplmngt.dto.PatientRecord;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {

}
