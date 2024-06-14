package com.rinicius.cryptography.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rinicius.cryptography.controller.dto.CreateCryptography;
import com.rinicius.cryptography.entity.CryptographyEntity;
import com.rinicius.cryptography.repository.CryptographyRepository;
import com.rinicius.cryptography.utils.ConvertingUtils;

@Service
public class CryptographyService {
    private final CryptographyRepository cryptographyRepository;

    public CryptographyService(CryptographyRepository cryptographyRepository) {
        this.cryptographyRepository = cryptographyRepository;
    }

    public void create(CreateCryptography create) {
        CryptographyEntity cryptography = new CryptographyEntity(ConvertingUtils.encrypt(create.userDocument()),
                ConvertingUtils.encrypt(create.creditCardToken()),
                create.value());

        this.cryptographyRepository.save(cryptography);
    }

    public List<CryptographyEntity> getAllCryptographies() {
        return cryptographyRepository.findAll();
    }

    public Optional<CryptographyEntity> getSingleEntity(UUID id) {
        Optional<CryptographyEntity> result = cryptographyRepository.findById(id);

        if (!result.isPresent()) {
            return result;
        }

        result.get().setUserDocument(ConvertingUtils.decrypt(result.get().getUserDocument()));
        result.get().setCreditCardToken(ConvertingUtils.decrypt(result.get().getCreditCardToken()));

        return result;
    }
}
