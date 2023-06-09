package com.springcourse.lessons.RestApp.repositories;

import com.springcourse.lessons.RestApp.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, String> {
    Optional<Sensor> findByName(String name);
}
