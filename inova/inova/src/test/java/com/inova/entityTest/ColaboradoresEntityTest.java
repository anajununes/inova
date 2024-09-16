package com.inova.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.inova.entities.ColaboradoresEntity;

public class ColaboradoresEntityTest {

    @Test
    public void testColaboradoresEntityCreation() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity(1L, "Nome", "email@example.com", "senha123", null);
        
        assertEquals(1L, colaborador.getId());
        assertEquals("Nome", colaborador.getNome());
        assertEquals("email@example.com", colaborador.getEmail());
        assertEquals("senha123", colaborador.getSenha());
    }

    @Test
    public void testSettersAndGetters() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity();
        colaborador.setId(2L);
        colaborador.setNome("Outro Nome");
        colaborador.setEmail("outroemail@example.com");
        colaborador.setSenha("novaSenha123");

        assertEquals(2L, colaborador.getId());
        assertEquals("Outro Nome", colaborador.getNome());
        assertEquals("outroemail@example.com", colaborador.getEmail());
        assertEquals("novaSenha123", colaborador.getSenha());
    }
}
