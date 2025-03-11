package com.example.hamburg.academy.spring.dao.repository;

import com.example.hamburg.academy.spring.dao.entity.JurisdictionEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JurisdictionRepository extends JpaRepository<JurisdictionEntity, String> {

    @Override
//    @EntityGraph(attributePaths = {"jurisdictions", "jurisdictions.jurisdiction"})
//    @Query("SELECT j FROM JurisdictionEntity j LEFT JOIN FETCH j.jurisdictions WHERE j.id = :id")
    Optional<JurisdictionEntity> findById(String id);
}
