package com.example.ProyectoApi.service;

import com.example.ProyectoApi.persistance.model.Developer;

public interface DeveloperService {
    
    public Developer createDeveloper(Developer developer);
    public void deleteDeveloper(Long id);
}
