package com.inova.repositories;

import com.inova.entities.IdeiasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeiasRepository extends JpaRepository<IdeiasEntity, Long> {
    List<IdeiasEntity> findByEventoId(Long eventoId);
}
