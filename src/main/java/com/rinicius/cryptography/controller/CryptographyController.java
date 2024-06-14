package com.rinicius.cryptography.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rinicius.cryptography.controller.dto.CreateCryptography;
import com.rinicius.cryptography.entity.CryptographyEntity;
import com.rinicius.cryptography.service.CryptographyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/cryptography")
@RestController
public class CryptographyController {

    private final CryptographyService cryptographyService;

    public CryptographyController(CryptographyService cryptographyService) {
        this.cryptographyService = cryptographyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CryptographyEntity>> getSingleEntity(@PathVariable String id) {

        var convertedId = UUID.fromString(id);

        Optional<CryptographyEntity> result = this.cryptographyService.getSingleEntity(convertedId);

        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CryptographyEntity>> getAllEntities() {
        List<CryptographyEntity> result = this.cryptographyService.getAllCryptographies();

        return ResponseEntity.ok().body(result);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PostMapping("/create")
    public void createPerson(@RequestBody CreateCryptography create) {
        this.cryptographyService.create(create);
    }

}
