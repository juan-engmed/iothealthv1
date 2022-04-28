package com.juanime.iot_health.heart_sensor.controller;

import com.juanime.iot_health.heart_sensor.dto.HeartSensorDTO;
import com.juanime.iot_health.heart_sensor.service.HeartSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController()
@CrossOrigin("*")
@RequestMapping("/heart-sensor")
public class HeartSensorController {

    private final HeartSensorService service;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/add-bpm-data")
    public HeartSensorDTO insertBpmData(@Valid @RequestBody HeartSensorDTO heartSensorDTO){

       return service.saveData(heartSensorDTO);
    }
}
