package com.example.hamburg.academy.spring.model.response;

import com.example.hamburg.academy.spring.dao.entity.JurisdictionEntity;
import com.example.hamburg.academy.spring.model.enums.JurisdictionType;
import com.example.hamburg.academy.spring.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JurisdictionResponse {
    private String id;
    private String name;
    private String address;
    private String sectionWhichItBelongs;
    private JurisdictionType type;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Builder.Default
    private List<JurisdictionEntity> jurisdictions = new ArrayList<>();
}
