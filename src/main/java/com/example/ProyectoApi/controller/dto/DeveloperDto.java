package com.example.ProyectoApi.controller.dto;

import lombok.Data;

@Data 
public class DeveloperDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
}
