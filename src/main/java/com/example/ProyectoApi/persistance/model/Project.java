package com.example.ProyectoApi.persistance.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "projects")
@NoArgsConstructor
@Getter 
@Setter 
public class Project {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "project_id")
    private Long projectId;
    @Column(name = "project_name")
    private String projectName;
    @Column (name = "description")
    private String projectDescription;
    @Column (name = "start_date")
    private LocalDate projectStartDate;
    @Column (name = "end_date")
    private LocalDate projectEndDate;
    @Column (name = "repository_url")
    private String projectRepositoryUrl;
    @Column (name = "demo_url")
    private String projectDemoUrl;
    @Column (name = "picture")
    private String projectPicture;
    @ManyToOne
    @JoinColumn (name = "status_id", referencedColumnName="status_id") 
    private Status status;
}
