package com.example.ProyectoApi.controller.converter;

import org.springframework.stereotype.Component;

import com.example.ProyectoApi.controller.dto.DeveloperDto;
import com.example.ProyectoApi.persistance.model.Developer;

@Component
public class DeveloperConverter {
    
    public DeveloperDto entityToDto(Developer developer) {
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setId(developer.getId());
        developerDto.setName(developer.getName());
        developerDto.setSurname(developer.getSurname());
        developerDto.setEmail(developer.getEmail());
        developerDto.setLinkedinUrl(developer.getLinkedinUrl());
        developerDto.setGithubUrl(developer.getGithubUrl());
        if (developer.getId() != null) {
            developerDto.setId(developer.getId());
        }
        return developerDto;
    }

    public Developer dtoToEntity(DeveloperDto developerDto) {
        Developer developer = new Developer();
        developer.setId(developerDto.getId());
        developer.setName(developerDto.getName());
        developer.setSurname(developerDto.getSurname());
        developer.setEmail(developerDto.getEmail());
        developer.setLinkedinUrl(developerDto.getLinkedinUrl());
        developer.setGithubUrl(developerDto.getGithubUrl());
        if (developerDto.getId() != null) {
            developer.setId(developerDto.getId());
        }
        return developer;
    }

}
