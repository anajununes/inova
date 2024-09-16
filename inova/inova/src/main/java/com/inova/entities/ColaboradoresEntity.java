package com.inova.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity (name = "colaboradores")
public class ColaboradoresEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
public enum Tipo {
	USUARIO, ADMIN, AVALIADOR, COLABORADOR
}

}
