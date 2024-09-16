package com.inova.controllers;

import com.inova.entities.EventosEntity;
import com.inova.entities.ColaboradoresEntity;
import com.inova.services.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping("/{id}")
    public ResponseEntity<EventosEntity> getEventoById(@PathVariable Long id) {
        EventosEntity evento = eventosService.findById(id);
        if (evento != null) {
            return new ResponseEntity<>(evento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
	@GetMapping("/findbydata")
	public ResponseEntity<EventosEntity> findByData(@PathVariable LocalDate inicio){
	    return ResponseEntity.ok(eventosService.findByData(inicio));
	}

    @PostMapping
    public ResponseEntity<EventosEntity> createEvento(@RequestBody EventosEntity evento) {
        EventosEntity savedEvento = eventosService.save(evento);
        return new ResponseEntity<>(savedEvento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/jurados")
    public ResponseEntity<EventosEntity> addJurados(@PathVariable Long id, @RequestBody List<ColaboradoresEntity> jurados) {
        EventosEntity updatedEvento = eventosService.addJurados(id, jurados);
        if (updatedEvento != null) {
            return new ResponseEntity<>(updatedEvento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
