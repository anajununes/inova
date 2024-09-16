package com.inova.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.entities.VotoEntity;
import com.inova.repositories.VotoRepository;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public VotoEntity findById(Long id) {
        Optional<VotoEntity> result = votoRepository.findById(id);
        return result.orElse(null);
    }

    public VotoEntity save(VotoEntity voto) {
        return votoRepository.save(voto);
    }
}
