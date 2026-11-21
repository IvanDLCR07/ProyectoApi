package com.example.ProyectoApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProyectoApi.service.TechnologiesService;

import com.example.ProyectoApi.controller.converter.TechnologiesConverter;
import com.example.ProyectoApi.controller.dto.TechnologiesDto;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/technologies")
@CrossOrigin
@AllArgsConstructor
public class TechnologiesController {
    
    TechnologiesService technologiesService;
    TechnologiesConverter technologiesConverter;

    @PostMapping
    public ResponseEntity<TechnologiesDto> postTechnologies(@RequestBody TechnologiesDto technologiesDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(technologiesConverter.entityToDto(technologiesService.postTechnologies(technologiesConverter.dtoToEntity(technologiesDto))));  
    }

    @DeleteMapping("/{techId}")
    public ResponseEntity<TechnologiesDto> deleteTechnologies(@PathVariable Long techId) {
        technologiesService.deleteTechnologies(techId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
