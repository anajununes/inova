package com.inova.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.entities.AvaliacaoEntity;
import com.inova.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Double calcularMediaNotas(Long ideiaId) {
        List<AvaliacaoEntity> avaliacoes = avaliacaoRepository.findByIdeiasId(ideiaId);
        if (avaliacoes.isEmpty()) {
            return null;
        }
        return avaliacoes.stream()
                         .mapToDouble(AvaliacaoEntity::getNota)
                         .average()
                         .orElse(0.0);
    }
    
    public AvaliacaoEntity findById(Long id) {
        Optional<AvaliacaoEntity> result = avaliacaoRepository.findById(id);
        return result.orElse(null);
    }

    public AvaliacaoEntity save(AvaliacaoEntity avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }
}
