package com.example.ProyectoApi.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoApi.persistance.model.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Long> {
    
}
