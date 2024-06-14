package com.rinicius.cryptography.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rinicius.cryptography.entity.CryptographyEntity;

public interface CryptographyRepository extends JpaRepository<CryptographyEntity, UUID> {
}
