package com.example.hamburg.academy.spring.dao.entity;

import com.example.hamburg.academy.spring.model.enums.JurisdictionType;
import com.example.hamburg.academy.spring.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Builder
@Table(name = "jurisdictions")
public class JurisdictionEntity {
    @Id
    private String id;

    private String name;

    private String address;

    private String sectionWhichItBelongs;

    @Enumerated(STRING)
    private JurisdictionType type;

    @Enumerated(STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = EAGER, cascade = {MERGE})
    @JsonIgnore
    private JurisdictionEntity jurisdiction;

    @OneToMany(mappedBy = "jurisdiction", fetch = EAGER, cascade = {PERSIST, MERGE})
    @Builder.Default
    private List<JurisdictionEntity> jurisdictions = new ArrayList<>();
}
