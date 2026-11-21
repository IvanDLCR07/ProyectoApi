package com.example.ProyectoApi.service;

import com.example.ProyectoApi.persistance.model.Technologies;

public interface TechnologiesService {
    
    public Technologies postTechnologies(Technologies technologies);
    public Technologies deleteTechnologies(Long techId);

}
