package com.example.ProyectoApi.service.Impl;

import org.springframework.stereotype.Service;

import com.example.ProyectoApi.persistance.model.Developer;
import com.example.ProyectoApi.persistance.repository.DeveloperRepository;
import com.example.ProyectoApi.service.DeveloperService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Override 
    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }

}
