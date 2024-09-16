package com.inova.controllers;

import com.inova.entities.VotoEntity;
import com.inova.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping("/{id}")
    public ResponseEntity<VotoEntity> getVotoById(@PathVariable Long id) {
        VotoEntity voto = votoService.findById(id);
        if (voto != null) {
            return new ResponseEntity<>(voto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VotoEntity> createVoto(@RequestBody VotoEntity voto) {
        VotoEntity savedVoto = votoService.save(voto);
        return new ResponseEntity<>(savedVoto, HttpStatus.CREATED);
    }

}
