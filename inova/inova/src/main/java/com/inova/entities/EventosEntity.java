package com.inova.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
@Entity
public class EventosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;
    private LocalDate inicio;
    private Date fim;
    private Date inicioAval;
    private Date fimAval;
    private Date voto;

    @ManyToMany
    private List<ColaboradoresEntity> jurados; // Mapeamento de jurados
}
