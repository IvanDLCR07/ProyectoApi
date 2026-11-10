package com.example.ProyectoApi.controller.converter;

import org.springframework.stereotype.Component;

import com.example.ProyectoApi.controller.dto.TechnologiesDto;
import com.example.ProyectoApi.persistance.model.Technologies;

import lombok.AllArgsConstructor;

@Component 
@AllArgsConstructor 
public class TechnologiesConverter {
    
    public TechnologiesDto entityToDto(Technologies technologies) {
        TechnologiesDto technologiesDto = new TechnologiesDto();
        technologiesDto.setTechId(technologies.getTechId());
        technologiesDto.setTechName(technologies.getTechName());
        return technologiesDto;
    }
    
    public Technologies dtoToEntity(TechnologiesDto technologiesDto) {
        Technologies technologies = new Technologies();
        technologies.setTechId(technologiesDto.getTechId());
        technologies.setTechName(technologiesDto.getTechName());
        return technologies;
    }

}
