package com.springcourse.lessons.RestApp.services;

import com.springcourse.lessons.RestApp.models.Sensor;
import com.springcourse.lessons.RestApp.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Optional<Sensor> findByName(String name) {
        return sensorsRepository.findByName(name);
    }

    public List<Sensor> findAll() {
        return sensorsRepository.findAll();
    }

    @Transactional
    public void register(Sensor sensor) {
        enrichSensor(sensor);
        sensorsRepository.save(sensor);
    }

    private void enrichSensor (Sensor sensor) {
        sensor.setRegisteredAt(LocalDateTime.now());
    }
}
