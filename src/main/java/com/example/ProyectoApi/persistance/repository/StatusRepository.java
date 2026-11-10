package com.example.ProyectoApi.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoApi.persistance.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    
}
