package com.inova.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.entities.ColaboradoresEntity;
import com.inova.entities.EventosEntity;
import com.inova.repositories.EventosRepository;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    public EventosEntity findById(Long id) {
        Optional<EventosEntity> result = eventosRepository.findById(id);
        return result.orElse(null);
    }

    public EventosEntity save(EventosEntity evento) {
        return eventosRepository.save(evento);
    }

    public EventosEntity addJurados(Long eventoId, List<ColaboradoresEntity> jurados) {
        Optional<EventosEntity> eventoOptional = eventosRepository.findById(eventoId);
        if (eventoOptional.isPresent()) {
            EventosEntity evento = eventoOptional.get();
            evento.getJurados().addAll(jurados);
            return eventosRepository.save(evento);
        }
        return null;
    }
    public EventosEntity findByData (LocalDate data) {
        try{
        	return eventosRepository.findByData(data).orElseThrow(); // orElseThrow(); é oq lança a exceção se der null
        }catch (Exception e){
            System.out.println(e.getCause()); //getCause indica pq ocorreu a exceção
            return new EventosEntity();
        }
    }
    
}
