package com.inova.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inova.entities.ColaboradoresEntity;


public interface ColaboradoresRepository extends JpaRepository<ColaboradoresEntity, Long>{
	List<ColaboradoresEntity> findByNome(String nome);
}
