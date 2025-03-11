package com.example.hamburg.academy.spring.mapper;

import com.example.hamburg.academy.spring.dao.entity.JurisdictionEntity;
import com.example.hamburg.academy.spring.model.request.JurisdictionRequest;
import com.example.hamburg.academy.spring.model.response.JurisdictionResponse;

import java.util.UUID;

import static com.example.hamburg.academy.spring.model.enums.Status.ACTIVE;

public enum JurisdictionMapper {
    JURISDICTION_MAPPER;

    public JurisdictionEntity convert(JurisdictionRequest request) {
        var id = UUID.randomUUID().toString();
        return JurisdictionEntity.builder()
                .id(id)
                .address(request.getAddress())
                .status(ACTIVE)
                .sectionWhichItBelongs(request.getSectionWhichItBelongs())
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public JurisdictionResponse buildJurisdictionResponse(JurisdictionEntity entity) {
        return JurisdictionResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .sectionWhichItBelongs(entity.getSectionWhichItBelongs())
                .type(entity.getType())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .jurisdictions(entity.getJurisdictions())
                .build();
    }
}
