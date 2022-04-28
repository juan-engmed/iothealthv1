package com.juanime.iot_health.heart_sensor.repository;

import com.juanime.iot_health.heart_sensor.entity.HeartSensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartSensorRepository extends CrudRepository<HeartSensor, Long> {
}
