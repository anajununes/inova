package com.inova.repositories;

import com.inova.entities.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByColaboradorId(Long colaboradorId);
    List<AvaliacaoEntity> findByIdeiasId(Long ideiaId);
}
