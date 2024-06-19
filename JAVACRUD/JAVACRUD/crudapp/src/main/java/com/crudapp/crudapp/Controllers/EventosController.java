package com.crudapp.crudapp.Controllers;

import com.crudapp.crudapp.Entities.Eventos;
import com.crudapp.crudapp.Repositories.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventosController {

    @Autowired
    private EventosRepository eventosRepository;

    @GetMapping
    public List<Eventos> getAllEventos() {
        return eventosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eventos> getEventosById(@PathVariable Long id) {
        Eventos eventos = eventosRepository.findById(id).orElse(null);
        if (eventos != null) {
            return ResponseEntity.ok(eventos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Eventos createEventos(@RequestBody Eventos eventos) {
        return eventosRepository.save(eventos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eventos> updateEventos(@PathVariable Long id, @RequestBody Eventos eventosNovos) {
        Eventos eventos = eventosRepository.findById(id).orElse(null);
        if (eventos != null) {
            eventos.setId(id);
            eventos.setNome(eventosNovos.getNome()); // Atualiza apenas o nome
            eventos.setEventoType(eventosNovos.getEventoType()); // Atualiza o tipo de evento
            eventosRepository.save(eventos);
            return ResponseEntity.ok(eventos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventos(@PathVariable Long id) {
        Eventos eventos = eventosRepository.findById(id).orElse(null);
        if (eventos != null) {
            eventosRepository.delete(eventos);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
