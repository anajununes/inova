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

import com.inova.controllers.AvaliacaoController;
import com.inova.entities.AvaliacaoEntity;
import com.inova.services.AvaliacaoService;

public class AvaliacaoControllerTest {

    @Mock
    private AvaliacaoService avaliacaoService;

    @InjectMocks
    private AvaliacaoController avaliacaoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAvaliacaoById() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setId(1L);
        when(avaliacaoService.findById(1L)).thenReturn(avaliacao);

        ResponseEntity<AvaliacaoEntity> response = avaliacaoController.getAvaliacaoById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(avaliacao, response.getBody());
    }

    @Test
    public void testGetAvaliacaoByIdNotFound() {
        when(avaliacaoService.findById(1L)).thenReturn(null);

        ResponseEntity<AvaliacaoEntity> response = avaliacaoController.getAvaliacaoById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateAvaliacao() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setId(1L);
        when(avaliacaoService.save(avaliacao)).thenReturn(avaliacao);

        ResponseEntity<AvaliacaoEntity> response = avaliacaoController.createAvaliacao(avaliacao);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(avaliacao, response.getBody());
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testGetAvaliacoesByIdeiaId() {
        AvaliacaoEntity avaliacao1 = new AvaliacaoEntity();
        AvaliacaoEntity avaliacao2 = new AvaliacaoEntity();
        List<AvaliacaoEntity> avaliacoes = Arrays.asList(avaliacao1, avaliacao2);
        when(avaliacaoService.findById(1L)).thenReturn((AvaliacaoEntity) avaliacoes);

        ResponseEntity<AvaliacaoEntity> response = avaliacaoController.getAvaliacaoById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, ((List<AvaliacaoEntity>) response.getBody()).size());
    }

    @Test
    public void testGetAvaliacoesByIdeiaIdNotFound() {
        when(avaliacaoService.findById(1L)).thenReturn((AvaliacaoEntity) Collections.emptyList());

        ResponseEntity<AvaliacaoEntity> response = avaliacaoController.getAvaliacaoById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
