package com.example.hamburg.academy.spring.model.request;

import com.example.hamburg.academy.spring.model.enums.JurisdictionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JurisdictionRequest {
    private String name;
    private String address;
    private String sectionWhichItBelongs;
    private JurisdictionType type;
}
