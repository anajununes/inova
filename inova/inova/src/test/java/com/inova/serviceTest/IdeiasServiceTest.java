package com.inova.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.inova.entities.AvaliacaoEntity;
import com.inova.entities.IdeiasEntity;
import com.inova.repositories.AvaliacaoRepository;
import com.inova.repositories.IdeiasRepository;
import com.inova.services.IdeiasService;

public class IdeiasServiceTest {

    @Mock
    private IdeiasRepository ideiasRepository;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private IdeiasService ideiasService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        IdeiasEntity ideia = new IdeiasEntity();
        ideia.setId(1L);
        when(ideiasRepository.findById(1L)).thenReturn(Optional.of(ideia));

        IdeiasEntity result = ideiasService.findById(1L);
        assertEquals(ideia, result);
    }

    @Test
    public void testFindByIdNotFound() {
        when(ideiasRepository.findById(1L)).thenReturn(Optional.empty());

        IdeiasEntity result = ideiasService.findById(1L);
        assertNull(result);
    }

    @Test
    public void testSave() {
        IdeiasEntity ideia = new IdeiasEntity();
        ideia.setId(1L);
        when(ideiasRepository.save(ideia)).thenReturn(ideia);

        IdeiasEntity result = ideiasService.save(ideia);
        assertEquals(ideia, result);
    }

    @Test
    public void testFindByEventoId() {
        IdeiasEntity ideia1 = new IdeiasEntity();
        IdeiasEntity ideia2 = new IdeiasEntity();
        List<IdeiasEntity> ideias = Arrays.asList(ideia1, ideia2);
        when(ideiasRepository.findByEventoId(1L)).thenReturn(ideias);

        List<IdeiasEntity> result = ideiasService.findByEventoId(1L);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindByEventoIdNotFound() {
        when(ideiasRepository.findByEventoId(1L)).thenReturn(Collections.emptyList());

        List<IdeiasEntity> result = ideiasService.findByEventoId(1L);
        assertEquals(0, result.size());
    }

    @Test
    public void testCalcularMediaNotas() {
        AvaliacaoEntity avaliacao1 = new AvaliacaoEntity();
        avaliacao1.setNota(8.0);
        AvaliacaoEntity avaliacao2 = new AvaliacaoEntity();
        avaliacao2.setNota(7.0);
        List<AvaliacaoEntity> avaliacoes = Arrays.asList(avaliacao1, avaliacao2);
        when(avaliacaoRepository.findByIdeiasId(1L)).thenReturn(avaliacoes);

        Double media = ideiasService.calcularMediaNotas(1L);
        assertEquals(7.5, media);
    }

    @Test
    public void testCalcularMediaNotasSemAvaliacoes() {
        when(avaliacaoRepository.findByIdeiasId(1L)).thenReturn(Collections.emptyList());

        Double media = ideiasService.calcularMediaNotas(1L);
        assertNull(media);
    }
}
