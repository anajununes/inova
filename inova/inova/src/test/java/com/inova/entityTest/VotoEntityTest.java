package com.inova.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.inova.entities.ColaboradoresEntity;
import com.inova.entities.IdeiasEntity;
import com.inova.entities.VotoEntity;

public class VotoEntityTest {

    @Test
    public void testVotoEntityCreation() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity(1L, "Nome", "email@example.com", "senha123", null);
        IdeiasEntity ideia = new IdeiasEntity(1L, "Ideia Teste", "Alto impacto", 1000.0, "Descrição da ideia", 9.5, null, null, null);
        VotoEntity voto = new VotoEntity(1L, 10, colaborador, ideia);

        assertEquals(1L, voto.getId());
        assertEquals(10, voto.getNota());
        assertEquals(colaborador, voto.getColaborador());
        assertEquals(ideia, voto.getIdeia());
    }

    @Test
    public void testSettersAndGetters() {
        VotoEntity voto = new VotoEntity();
        voto.setNota(8);

        assertEquals(8, voto.getNota());
    }
}
