package com.example.hamburg.academy.spring.controller;

import com.example.hamburg.academy.spring.model.request.JurisdictionRequest;
import com.example.hamburg.academy.spring.model.response.JurisdictionResponse;
import com.example.hamburg.academy.spring.service.abstraction.JurisdictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/jurisdictions")
@RequiredArgsConstructor
public class JurisdictionController {
    private final JurisdictionService jurisdictionService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addJurisdiction(@RequestBody JurisdictionRequest request) {
        jurisdictionService.addJurisdiction(request);
    }

    @GetMapping("/{jurisdictionId}")
    public JurisdictionResponse getJurisdiction(@PathVariable String jurisdictionId) {
        return jurisdictionService.getJurisdiction(jurisdictionId);
    }
}
