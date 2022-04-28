package com.juanime.iot_health.heart_sensor.repository;

import com.juanime.iot_health.patient.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
