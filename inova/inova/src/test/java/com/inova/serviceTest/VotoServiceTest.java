package com.inova.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.inova.entities.VotoEntity;
import com.inova.repositories.VotoRepository;
import com.inova.services.VotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class VotoServiceTest {

    @Mock
    private VotoRepository votoRepository;

    @InjectMocks
    private VotoService votoService;

    private VotoEntity voto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        voto = new VotoEntity(1L, 9, null, null);
    }

    @Test
    public void testFindById() {
        when(votoRepository.findById(1L)).thenReturn(Optional.of(voto));
        VotoEntity found = votoService.findById(1L);
        assertNotNull(found);
        assertEquals(9, found.getNota());
    }

    @Test
    public void testSave() {
        when(votoRepository.save(voto)).thenReturn(voto);
        VotoEntity saved = votoService.save(voto);
        assertNotNull(saved);
        assertEquals(9, saved.getNota());
    }
}
