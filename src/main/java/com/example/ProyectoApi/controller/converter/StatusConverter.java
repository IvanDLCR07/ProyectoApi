package com.example.ProyectoApi.controller.converter;

import org.springframework.stereotype.Component;

import com.example.ProyectoApi.controller.dto.StatusDto;
import com.example.ProyectoApi.persistance.model.Status;

import lombok.AllArgsConstructor;

@Component 
@AllArgsConstructor 
public class StatusConverter {
    
    public StatusDto entityToDto(Status status) {
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusId(status.getStatus_id());
        statusDto.setStatusName(status.getStatus_name());
        return statusDto;
    }

    public Status dtoToEntity(StatusDto statusDto) {
        Status status = new Status();
        status.setStatus_id(statusDto.getStatusId());
        status.setStatus_name(statusDto.getStatusName());
        return status;
    }

}
