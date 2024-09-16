package com.inova.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.inova.entities.EventosEntity;

public class EventosEntityTest {

    @Test
    public void testEventosEntityCreation() {
        Date inicio = new Date(System.currentTimeMillis());
        Date fim = new Date(System.currentTimeMillis() + 10000);
        EventosEntity evento = new EventosEntity(1L, "Evento Teste", "Descrição Teste", inicio, fim, inicio, fim, inicio, new ArrayList<>());

        assertEquals(1L, evento.getId());
        assertEquals("Evento Teste", evento.getNome());
        assertEquals("Descrição Teste", evento.getDescricao());
        assertEquals(inicio, evento.getInicio());
        assertEquals(fim, evento.getFim());
    }

    @Test
    public void testSettersAndGetters() {
        Date data = new Date(System.currentTimeMillis());
        EventosEntity evento = new EventosEntity();
        evento.setNome("Nome Evento");
        evento.setDescricao("Descricao Evento");
        evento.setInicio(data);
        evento.setFim(data);

        assertEquals("Nome Evento", evento.getNome());
        assertEquals("Descricao Evento", evento.getDescricao());
        assertEquals(data, evento.getInicio());
        assertEquals(data, evento.getFim());
    }
}
