package com.rinicius.cryptography.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CryptographyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @lombok.NonNull
    @Column(name = "userDocument")
    private String userDocument;

    @lombok.NonNull
    @Column(name = "creditCardToken")
    private String creditCardToken;

    @lombok.NonNull
    @Column(name = "value")
    private Long value;

}
