package com.juanime.iot_health.heart_sensor.dto;

import com.juanime.iot_health.smart_band.entity.SmartBand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeartSensorDTO {

    @NotNull
    private Integer bpm;

    @NotNull
    private Long smartBandId;

}
