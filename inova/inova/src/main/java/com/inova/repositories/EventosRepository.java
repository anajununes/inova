package com.inova.repositories;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inova.entities.EventosEntity;
import com.inova.entities.IdeiasEntity;

@Repository
public interface EventosRepository extends JpaRepository<EventosEntity, Long> {
	List<IdeiasEntity> findByEventoId(Long eventoId);
	Optional<EventosEntity> findByData(LocalDate data);
}

