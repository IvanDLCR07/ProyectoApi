package com.example.ProyectoApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProyectoApi.controller.converter.DeveloperConverter;
import com.example.ProyectoApi.controller.dto.DeveloperDto;
import com.example.ProyectoApi.service.DeveloperService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/developers")
@CrossOrigin
@AllArgsConstructor 
public class DeveloperController {
    
    DeveloperService developerService;
    DeveloperConverter developerConverter;

    @PostMapping 
    public ResponseEntity<DeveloperDto> createDeveloper(@RequestBody DeveloperDto developerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(developerConverter.entityToDto(developerService.createDeveloper(developerConverter.dtoToEntity(developerDto))));
    }

}
