package com.inova.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.inova.entities.EventosEntity;
import com.inova.entities.ColaboradoresEntity;
import com.inova.repositories.EventosRepository;
import com.inova.services.EventosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EventosServiceTest {

    @Mock
    private EventosRepository eventosRepository;

    @InjectMocks
    private EventosService eventosService;

    private EventosEntity evento;
    private ColaboradoresEntity colaborador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        colaborador = new ColaboradoresEntity(1L, "John Doe", "john@example.com", "password123", null);
        evento = new EventosEntity(1L, "Evento1", "Descrição", null, null, null, null, null, null);
    }

    @Test
    public void testFindById() {
        when(eventosRepository.findById(1L)).thenReturn(Optional.of(evento));
        EventosEntity found = eventosService.findById(1L);
        assertNotNull(found);
        assertEquals("Evento1", found.getNome());
    }

    @Test
    public void testSave() {
        when(eventosRepository.save(evento)).thenReturn(evento);
        EventosEntity saved = eventosService.save(evento);
        assertNotNull(saved);
        assertEquals("Evento1", saved.getNome());
    }

    @Test
    public void testAddJurados() {
        when(eventosRepository.findById(1L)).thenReturn(Optional.of(evento));
        when(eventosRepository.save(evento)).thenReturn(evento);

        List<ColaboradoresEntity> jurados = Arrays.asList(colaborador);
        EventosEntity updated = eventosService.addJurados(1L, jurados);
        assertNotNull(updated);
        assertTrue(updated.getJurados().contains(colaborador));
    }
}
