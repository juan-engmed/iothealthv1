package com.juanime.iot_health.smart_band.controller;

import com.juanime.iot_health.smart_band.dto.SmartBandDTO;
import com.juanime.iot_health.smart_band.service.SmartBandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/smart-band")
public class SmartBandController {

    private final SmartBandService service;


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/add")
    public SmartBandDTO createSmartBand(@Valid @RequestBody SmartBandDTO smartBandDTO){

        return service.saveSmartBand(smartBandDTO);
    }
}
