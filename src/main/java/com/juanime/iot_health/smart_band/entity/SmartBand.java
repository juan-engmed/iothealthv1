package com.juanime.iot_health.smart_band.entity;

import com.juanime.iot_health.patient.entity.Patient;
import lombok.AccessLevel;
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
@Data
@Table(name = "smart_band")
@Entity(name = "smart_band")
public class SmartBand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mac_adress")
    private String macAddress;

    @Column(name = "model")
    private String model;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Setter(AccessLevel.PRIVATE)
    @Column(updatable = false)
    private LocalDateTime created;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }

}
