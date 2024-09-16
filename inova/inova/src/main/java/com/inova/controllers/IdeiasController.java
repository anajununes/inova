package com.inova.controllers;

import com.inova.entities.IdeiasEntity;
import com.inova.services.IdeiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideias")
public class IdeiasController {

    @Autowired
    private IdeiasService ideiasService;

    @GetMapping("/{id}")
    public ResponseEntity<IdeiasEntity> getIdeiaById(@PathVariable Long id) {
        IdeiasEntity ideia = ideiasService.findById(id);
        if (ideia != null) {
            return new ResponseEntity<>(ideia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IdeiasEntity> createIdeia(@RequestBody IdeiasEntity ideia) {
        IdeiasEntity savedIdeia = ideiasService.save(ideia);
        return new ResponseEntity<>(savedIdeia, HttpStatus.CREATED);
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<IdeiasEntity>> getIdeiasByEventoId(@PathVariable Long eventoId) {
        List<IdeiasEntity> ideias = ideiasService.findByEventoId(eventoId);
        if (ideias != null && !ideias.isEmpty()) {
            return new ResponseEntity<>(ideias, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
