package com.example.hamburg.academy.spring.service.concrete;

import com.example.hamburg.academy.spring.dao.entity.JurisdictionEntity;
import com.example.hamburg.academy.spring.dao.repository.JurisdictionRepository;
import com.example.hamburg.academy.spring.exception.NotFoundException;
import com.example.hamburg.academy.spring.model.request.JurisdictionRequest;
import com.example.hamburg.academy.spring.model.response.JurisdictionResponse;
import com.example.hamburg.academy.spring.service.abstraction.JurisdictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.hamburg.academy.spring.exception.ExceptionConstants.JURISDICTION_NOT_FOUND;
import static com.example.hamburg.academy.spring.mapper.JurisdictionMapper.JURISDICTION_MAPPER;

@Service
@RequiredArgsConstructor
public class JurisdictionServiceHandler implements JurisdictionService {
    private final JurisdictionRepository jurisdictionRepository;

    @Override
    public void addJurisdiction(JurisdictionRequest request) {
        var jurisdictionEntity = JURISDICTION_MAPPER.convert(request);

        if (request.getSectionWhichItBelongs() != null) {
            var jurisdiction = fetchJurisdictionIfExist(request.getSectionWhichItBelongs());
            jurisdictionEntity.setJurisdiction(jurisdiction);
        }

        jurisdictionRepository.save(jurisdictionEntity);
    }

    @Override
    public JurisdictionResponse getJurisdiction(String jurisdictionId) {
        var jurisdictionEntity = fetchJurisdictionIfExist(jurisdictionId);
        return JURISDICTION_MAPPER.buildJurisdictionResponse(jurisdictionEntity);
    }

    private JurisdictionEntity fetchJurisdictionIfExist(String jurisdictionId) {
        return jurisdictionRepository.findById(jurisdictionId)
                .orElseThrow(() -> new NotFoundException(
                        JURISDICTION_NOT_FOUND.getCode(), JURISDICTION_NOT_FOUND.getMessage())
                );
    }

}
