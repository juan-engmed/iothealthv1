package com.juanime.iot_health.heart_sensor.entity;

import com.juanime.iot_health.smart_band.entity.SmartBand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "heart_sensor")
@Entity(name = "heart_sensor")
public class HeartSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bpm")
    private Integer bpm;

    @OneToOne
    @JoinColumn(name = "smart_band_id")
    private SmartBand smartBand;

    @Setter(AccessLevel.PRIVATE)
    @Column(updatable = false)
    private LocalDateTime created;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }
}
