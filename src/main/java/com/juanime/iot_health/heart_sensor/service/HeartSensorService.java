package com.juanime.iot_health.heart_sensor.service;

import com.juanime.iot_health.exception.SearchNotFoundException;
import com.juanime.iot_health.heart_sensor.dto.HeartSensorDTO;
import com.juanime.iot_health.heart_sensor.entity.HeartSensor;
import com.juanime.iot_health.heart_sensor.repository.HeartSensorRepository;
import com.juanime.iot_health.smart_band.entity.SmartBand;
import com.juanime.iot_health.smart_band.repository.SmartBandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HeartSensorService {

    private final HeartSensorRepository repository;

    private final SmartBandRepository smartBandRepository;

    public HeartSensorDTO saveData(HeartSensorDTO heartSensorDTO){

        var smartBand = smartBandRepository.findById(heartSensorDTO.getSmartBandId())
                .orElseThrow(() -> new SearchNotFoundException("SmartBand", heartSensorDTO.getSmartBandId()));

        var heartSensorSaved = repository.save
                (convertDTOtoEntity(heartSensorDTO, smartBand, new HeartSensor()));

        return convertEntityToDTO(heartSensorSaved);
    }

    public HeartSensor convertDTOtoEntity(HeartSensorDTO heartSensorDTO, SmartBand smartBand, HeartSensor heartSensor){

        heartSensor.setBpm(heartSensorDTO.getBpm());
        heartSensor.setSmartBand(smartBand);

        return heartSensor;
    }

    public HeartSensorDTO convertEntityToDTO(HeartSensor heartSensor){

        return HeartSensorDTO.builder()
                .bpm(heartSensor.getBpm())
                .smartBandId(heartSensor.getSmartBand().getId())
                .build();
    }

}
