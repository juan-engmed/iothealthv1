package com.juanime.iot_health.smart_band.service;

import com.juanime.iot_health.exception.SearchNotFoundException;
import com.juanime.iot_health.heart_sensor.repository.PatientRepository;
import com.juanime.iot_health.patient.entity.Patient;
import com.juanime.iot_health.smart_band.dto.SmartBandDTO;
import com.juanime.iot_health.smart_band.entity.SmartBand;
import com.juanime.iot_health.smart_band.repository.SmartBandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SmartBandService {

    private final SmartBandRepository repository;

    private final PatientRepository patientRepository;

    public SmartBandDTO saveSmartBand(SmartBandDTO smartBandDTO){

        var patient = patientRepository.findById(smartBandDTO.getPatientId())
                .orElseThrow(() -> new SearchNotFoundException("Paciente", smartBandDTO.getPatientId()));


        var smartBand = convertDTOtoEntity(smartBandDTO, patient, new SmartBand());

        var smartBandSaved = repository.save(smartBand);

        patient.setSmartBand(smartBandSaved);
        patientRepository.save(patient);

        return convertEntityToDTO(smartBandSaved);
    }

    public SmartBand convertDTOtoEntity(SmartBandDTO smartBandDTO, Patient patient, SmartBand smartBand){

        smartBand.setName(smartBandDTO.getName());
        smartBand.setMacAddress(smartBandDTO.getMacAddress());
        smartBand.setModel(smartBandDTO.getModel());
        smartBand.setPatient(patient);

        return smartBand;
    }

    public SmartBandDTO convertEntityToDTO(SmartBand smartBand){

        return SmartBandDTO.builder()
                .name(smartBand.getName())
                .macAddress(smartBand.getMacAddress())
                .model(smartBand.getModel())
                .patientId(smartBand.getPatient().getId())
                .build();
    }
}
