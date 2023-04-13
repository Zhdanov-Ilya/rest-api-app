package com.springcourse.lessons.RestApp.controllers;

import com.springcourse.lessons.RestApp.dto.MeasurementDTO;
import com.springcourse.lessons.RestApp.models.Measurement;
import com.springcourse.lessons.RestApp.services.MeasurementService;
import com.springcourse.lessons.RestApp.util.SensorValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementController(MeasurementService measurementService,
                                 ModelMapper modelMapper,
                                 MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                     BindingResult bindingResult) {
        Measurement measurementToAdd = convertToMeasurement(measurementDTO);
        sensorValidator.validate(measurementToAdd, bindingResult);

        measurementService.add(measurementToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public List<MeasurementDTO> getMeasurements() {
        return measurementService.findAllMeasurements().stream().map(this::convertToMeasurementDTO)
                .collect(Collectors.toList());
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
