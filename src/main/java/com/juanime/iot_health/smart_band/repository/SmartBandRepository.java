package com.juanime.iot_health.smart_band.repository;

import com.juanime.iot_health.smart_band.entity.SmartBand;
import org.springframework.data.repository.CrudRepository;

public interface SmartBandRepository extends CrudRepository<SmartBand, Long> {
}
