package com.example.ProyectoApi.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "developers")
@NoArgsConstructor 
@Getter 
@Setter 
public class Developer {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Long id;
    @Column (name = "dev_name")
    private String name;
    @Column (name = "dev_surname")
    private String surname;
    @Column (name = "email")
    private String email;
    @Column (name = "linkedin_url")
    private String linkedinUrl;
    @Column (name = "github_url")
    private String githubUrl;

}
