package com.inova.controllers;

import com.inova.entities.AvaliacaoEntity;
import com.inova.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoEntity> getAvaliacaoById(@PathVariable Long id) {
        AvaliacaoEntity avaliacao = avaliacaoService.findById(id);
        if (avaliacao != null) {
            return new ResponseEntity<>(avaliacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AvaliacaoEntity> createAvaliacao(@RequestBody AvaliacaoEntity avaliacao) {
        AvaliacaoEntity savedAvaliacao = avaliacaoService.save(avaliacao);
        return new ResponseEntity<>(savedAvaliacao, HttpStatus.CREATED);
    }

}
