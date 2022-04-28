package com.juanime.iot_health.smart_band.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmartBandDTO {

    @NotNull
    private String name;

    @NotNull
    @Column(name = "mac_adress")
    private String macAddress;

    @NotNull
    @Column(name = "model")
    private String model;

    @NotNull
    private Long patientId;

}
