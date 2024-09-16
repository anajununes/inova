package com.inova.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.entities.ColaboradoresEntity;
import com.inova.repositories.ColaboradoresRepository;

@Service
public class ColaboradoresService {

    @Autowired
    private ColaboradoresRepository colaboradoresRepository;

    public ColaboradoresEntity findById(Long id) {
        Optional<ColaboradoresEntity> result = colaboradoresRepository.findById(id);
        return result.orElse(null);
    }
    

    public List<ColaboradoresEntity> findByNome(String nome) {
        return colaboradoresRepository.findByNome(nome);
    }
    public ColaboradoresEntity save(ColaboradoresEntity colaborador) {
        return colaboradoresRepository.save(colaborador);
    }

    public ColaboradoresEntity updateProfile(Long id, String perfil) {
        Optional<ColaboradoresEntity> colaboradorOptional = colaboradoresRepository.findById(id);
        if (colaboradorOptional.isPresent()) {
            ColaboradoresEntity colaborador = colaboradorOptional.get();
            colaborador.setEmail(perfil);
            return colaboradoresRepository.save(colaborador);
        }
        return null;
    }
}
