package com.example.ProyectoApi.service.Impl;

import org.springframework.stereotype.Service;

import com.example.ProyectoApi.persistance.model.Technologies;
import com.example.ProyectoApi.persistance.repository.TechnologiesRepository;
import com.example.ProyectoApi.service.TechnologiesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologiesServiceImpl implements TechnologiesService {
    
    private final TechnologiesRepository technologiesRepository;

    @Override
    public Technologies postTechnologies(Technologies technologies) {
        technologies.setTechId(null); 
        return technologiesRepository.save(technologies);
    }

    @Override
    public Technologies deleteTechnologies(Long techId) {
        Technologies technologies = technologiesRepository.findById(techId).orElse(null);
        if (technologies != null) {
            technologiesRepository.delete(technologies);
        }
        return technologies;
    }

}
