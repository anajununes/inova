package com.inova.controllerTest;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inova.controllers.EventosController;
import com.inova.entities.EventosEntity;
import com.inova.services.EventosService;

public class EventosControllerTest {

    @Mock
    private EventosService eventosService;

    @InjectMocks
    private EventosController eventosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEventoById() {
        EventosEntity evento = new EventosEntity();
        evento.setId(1L);
        when(eventosService.findById(1L)).thenReturn(evento);

        ResponseEntity<EventosEntity> response = eventosController.getEventoById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(evento, response.getBody());
    }

    @Test
    public void testGetEventoByIdNotFound() {
        when(eventosService.findById(1L)).thenReturn(null);

        ResponseEntity<EventosEntity> response = eventosController.getEventoById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateEvento() {
        EventosEntity evento = new EventosEntity();
        evento.setId(1L);
        when(eventosService.save(evento)).thenReturn(evento);

        ResponseEntity<EventosEntity> response = eventosController.createEvento(evento);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(evento, response.getBody());
    }

    @Test
    public void testGetEventosByData() {
        EventosEntity evento1 = new EventosEntity();
        EventosEntity evento2 = new EventosEntity();
        List<EventosEntity> eventos = Arrays.asList(evento1, evento2);
        LocalDate data = LocalDate.of(2024, 9, 15);
        when(eventosService.findByData(data)).thenReturn((EventosEntity) eventos);

        ResponseEntity<List<EventosEntity>> response = eventosController.getEventosByData("2024-09-15");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetEventosByDataNotFound() {
    	LocalDate data = LocalDate.of(2024, 9, 15);
        when(eventosService.findByData(data)).thenReturn((EventosEntity) Collections.emptyList());

        ResponseEntity<List<EventosEntity>> response = eventosController.getEventosByData("2024-09-15");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
