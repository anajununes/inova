package com.inova.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ideias")
@Entity
public class IdeiasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String impacto;
    private Double custo;

    @Column(length = 1000)
    private String descricao;
    
    private Double nota;

    @ManyToOne
    private EventosEntity evento; // Relação com evento

    @ManyToMany
    private List<ColaboradoresEntity> colaboradores; // Ajustado para ManyToMany

    @OneToMany(mappedBy = "ideia") // Relacionado pela chave estrangeira da avaliação
    private List<AvaliacaoEntity> avaliacoes; // Plural para refletir lista de avaliações
}
