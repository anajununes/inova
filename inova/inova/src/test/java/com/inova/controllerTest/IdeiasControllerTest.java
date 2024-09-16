package com.inova.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

import com.inova.controllers.IdeiasController;
import com.inova.entities.IdeiasEntity;
import com.inova.services.IdeiasService;

public class IdeiasControllerTest {

    @Mock
    private IdeiasService ideiasService;

    @InjectMocks
    private IdeiasController ideiasController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetIdeiaById() {
        IdeiasEntity ideia = new IdeiasEntity();
        ideia.setId(1L);
        when(ideiasService.findById(1L)).thenReturn(ideia);

        ResponseEntity<IdeiasEntity> response = ideiasController.getIdeiaById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ideia, response.getBody());
    }

    @Test
    public void testGetIdeiaByIdNotFound() {
        when(ideiasService.findById(1L)).thenReturn(null);

        ResponseEntity<IdeiasEntity> response = ideiasController.getIdeiaById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateIdeia() {
        IdeiasEntity ideia = new IdeiasEntity();
        ideia.setId(1L);
        when(ideiasService.save(ideia)).thenReturn(ideia);

        ResponseEntity<IdeiasEntity> response = ideiasController.createIdeia(ideia);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ideia, response.getBody());
    }

    @Test
    public void testGetIdeiasByEventoId() {
        IdeiasEntity ideia1 = new IdeiasEntity();
        IdeiasEntity ideia2 = new IdeiasEntity();
        List<IdeiasEntity> ideias = Arrays.asList(ideia1, ideia2);
        when(ideiasService.findByEventoId(1L)).thenReturn(ideias);

        ResponseEntity<List<IdeiasEntity>> response = ideiasController.getIdeiasByEventoId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetIdeiasByEventoIdNotFound() {
        when(ideiasService.findByEventoId(1L)).thenReturn(Collections.emptyList());

        ResponseEntity<List<IdeiasEntity>> response = ideiasController.getIdeiasByEventoId(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
