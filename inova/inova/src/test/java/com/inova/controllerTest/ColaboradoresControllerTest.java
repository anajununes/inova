package com.inova.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.inova.controllers.ColaboradoresController;
import com.inova.entities.ColaboradoresEntity;
import com.inova.services.ColaboradoresService;

public class ColaboradoresControllerTest {

    @Mock
    private ColaboradoresService colaboradoresService;

    @InjectMocks
    private ColaboradoresController colaboradoresController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetColaboradorById() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity();
        colaborador.setId(1L);
        when(colaboradoresService.findById(1L)).thenReturn(colaborador);

        ResponseEntity<ColaboradoresEntity> response = colaboradoresController.getColaboradorById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(colaborador, response.getBody());
    }

    @Test
    public void testGetColaboradorByIdNotFound() {
        when(colaboradoresService.findById(1L)).thenReturn(null);

        ResponseEntity<ColaboradoresEntity> response = colaboradoresController.getColaboradorById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateColaborador() {
        ColaboradoresEntity colaborador = new ColaboradoresEntity();
        colaborador.setId(1L);
        when(colaboradoresService.save(colaborador)).thenReturn(colaborador);

        ResponseEntity<ColaboradoresEntity> response = colaboradoresController.createColaborador(colaborador);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(colaborador, response.getBody());
    }

    @Test
    public void testGetColaboradoresByNome() {
        ColaboradoresEntity colaborador1 = new ColaboradoresEntity();
        ColaboradoresEntity colaborador2 = new ColaboradoresEntity();
        List<ColaboradoresEntity> colaboradores = Arrays.asList(colaborador1, colaborador2);
        
        when(colaboradoresService.findByNome("João")).thenReturn(colaboradores);
        ResponseEntity<List<ColaboradoresEntity>> response = colaboradoresController.getColaboradoresByNome("João");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetColaboradoresByNomeNotFound() {
        when(colaboradoresService.findByNome("João")).thenReturn(Collections.emptyList());
        ResponseEntity<List<ColaboradoresEntity>> response = colaboradoresController.getColaboradoresByNome("João");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}

