package com.inova.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.entities.AvaliacaoEntity;
import com.inova.entities.IdeiasEntity;
import com.inova.repositories.AvaliacaoRepository;
import com.inova.repositories.IdeiasRepository;

@Service
public class IdeiasService {

    @Autowired
    private IdeiasRepository ideiasRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public IdeiasEntity findById(Long id) {
        Optional<IdeiasEntity> result = ideiasRepository.findById(id);
        return result.orElse(null);
    }

    public IdeiasEntity save(IdeiasEntity ideia) {
        return ideiasRepository.save(ideia);
    }

    public List<IdeiasEntity> findByEventoId(Long eventoId) {
        return ideiasRepository.findByEventoId(eventoId);
    }

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
}
