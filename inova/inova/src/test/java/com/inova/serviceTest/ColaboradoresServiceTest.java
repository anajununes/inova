package com.inova.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.inova.entities.ColaboradoresEntity;
import com.inova.repositories.ColaboradoresRepository;
import com.inova.services.ColaboradoresService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class ColaboradoresServiceTest {

    @Mock
    private ColaboradoresRepository colaboradoresRepository;

    @InjectMocks
    private ColaboradoresService colaboradoresService;

    private ColaboradoresEntity colaborador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        colaborador = new ColaboradoresEntity(1L, "John Doe", "john@example.com", "password123", null);
    }

    @Test
    public void testFindById() {
        when(colaboradoresRepository.findById(1L)).thenReturn(Optional.of(colaborador));
        ColaboradoresEntity found = colaboradoresService.findById(1L);
        assertNotNull(found);
        assertEquals("John Doe", found.getNome());
    }

    @Test
    public void testSave() {
        when(colaboradoresRepository.save(colaborador)).thenReturn(colaborador);
        ColaboradoresEntity saved = colaboradoresService.save(colaborador);
        assertNotNull(saved);
        assertEquals("John Doe", saved.getNome());
    }

    @Test
    public void testUpdateProfile() {
        when(colaboradoresRepository.findById(1L)).thenReturn(Optional.of(colaborador));
        when(colaboradoresRepository.save(colaborador)).thenReturn(colaborador);

        ColaboradoresEntity updated = colaboradoresService.updateProfile(1L, "newPerfil");
        assertNotNull(updated);
        assertEquals("newPerfil", updated.getEmail());
    }
}
