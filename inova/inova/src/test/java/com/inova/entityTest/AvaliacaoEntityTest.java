package com.inova.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.inova.entities.AvaliacaoEntity;
import com.inova.entities.ColaboradoresEntity;
import com.inova.entities.IdeiasEntity;

public class AvaliacaoEntityTest {

    @Test
    public void testAvaliacaoEntityCreation() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity(1L, "Nome", "email@example.com", "senha123", null);
        IdeiasEntity ideia = new IdeiasEntity(1L, "Ideia Teste", "Alto impacto", 1000.0, "Descrição da ideia", 9.5, null, null, null);
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();

        assertEquals(1L, avaliacao.getId());
        assertEquals(8, avaliacao.getNota());
        assertEquals(colaborador, avaliacao.getColaborador());
        assertEquals(ideia, avaliacao.getIdeia());
    }

    @Test
    public void testSettersAndGetters() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setNota(9.0);

        assertEquals(9, avaliacao.getNota());
    }
}
