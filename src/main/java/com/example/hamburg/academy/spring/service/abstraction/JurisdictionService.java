package com.example.hamburg.academy.spring.service.abstraction;

import com.example.hamburg.academy.spring.model.request.JurisdictionRequest;
import com.example.hamburg.academy.spring.model.response.JurisdictionResponse;

public interface JurisdictionService {
    void addJurisdiction(JurisdictionRequest request);

    JurisdictionResponse getJurisdiction(String jurisdictionId);
}
