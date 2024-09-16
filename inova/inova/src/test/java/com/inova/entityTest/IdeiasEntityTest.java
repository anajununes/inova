package com.inova.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.inova.entities.IdeiasEntity;

public class IdeiasEntityTest {

    @Test
    public void testIdeiasEntityCreation() {
        IdeiasEntity ideia = new IdeiasEntity(1L, "Ideia Teste", "Alto impacto", 1000.0, "Descrição da ideia", 9.5, null, new ArrayList<>(), new ArrayList<>());
        
        assertEquals(1L, ideia.getId());
        assertEquals("Ideia Teste", ideia.getNome());
        assertEquals("Alto impacto", ideia.getImpacto());
        assertEquals(1000.0, ideia.getCusto());
        assertEquals("Descrição da ideia", ideia.getDescricao());
        assertEquals(9.5, ideia.getNota());
    }

    @Test
    public void testSettersAndGetters() {
        IdeiasEntity ideia = new IdeiasEntity();
        ideia.setNome("Nova Ideia");
        ideia.setImpacto("Impacto Moderado");
        ideia.setCusto(500.0);
        ideia.setDescricao("Nova descrição");

        assertEquals("Nova Ideia", ideia.getNome());
        assertEquals("Impacto Moderado", ideia.getImpacto());
        assertEquals(500.0, ideia.getCusto());
        assertEquals("Nova descrição", ideia.getDescricao());
    }
}
