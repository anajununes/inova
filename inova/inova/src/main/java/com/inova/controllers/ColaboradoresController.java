package com.inova.controllers;


import com.inova.entities.ColaboradoresEntity;
import com.inova.services.ColaboradoresService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {

    @Autowired
    private ColaboradoresService colaboradoresService;

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradoresEntity> getColaboradorById(@PathVariable Long id) {
        ColaboradoresEntity colaborador = colaboradoresService.findById(id);
        if (colaborador != null) {
            return new ResponseEntity<>(colaborador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ColaboradoresEntity> createColaborador(@RequestBody ColaboradoresEntity colaborador) {
        ColaboradoresEntity savedColaborador = colaboradoresService.save(colaborador);
        return new ResponseEntity<>(savedColaborador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradoresEntity> updateColaborador(@PathVariable Long id, @RequestBody ColaboradoresEntity colaborador) {
        ColaboradoresEntity existingColaborador = colaboradoresService.findById(id);
        if (existingColaborador != null) {
            colaborador.setId(id); // Ensure the ID is set
            ColaboradoresEntity updatedColaborador = colaboradoresService.save(colaborador);
            return new ResponseEntity<>(updatedColaborador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ColaboradoresEntity>> getColaboradoresByNome(@PathVariable String nome) {
        List<ColaboradoresEntity> colaboradores = colaboradoresService.findByNome(nome);
        if (!colaboradores.isEmpty()) {
            return new ResponseEntity<>(colaboradores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
