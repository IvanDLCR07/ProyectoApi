package com.example.ProyectoApi.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoApi.persistance.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    
}
