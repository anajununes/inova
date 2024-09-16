package com.inova.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.inova.entities.AvaliacaoEntity;
import com.inova.repositories.AvaliacaoRepository;
import com.inova.services.AvaliacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class AvaliacaoServiceTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoService avaliacaoService;

    private AvaliacaoEntity avaliacao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        avaliacao = new AvaliacaoEntity();
    }

    @Test
    public void testFindById() {
        when(avaliacaoRepository.findById(1L)).thenReturn(Optional.of(avaliacao));
        AvaliacaoEntity found = avaliacaoService.findById(1L);
        assertNotNull(found);
        assertEquals(8, found.getNota());
    }

    @Test
    public void testSave() {
        when(avaliacaoRepository.save(avaliacao)).thenReturn(avaliacao);
        AvaliacaoEntity saved = avaliacaoService.save(avaliacao);
        assertNotNull(saved);
        assertEquals(8, saved.getNota());
    }
}
