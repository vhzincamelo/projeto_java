package com.crudapp.crudapp.Controllers;

import com.crudapp.crudapp.Entities.EventoType;
import com.crudapp.crudapp.Repositories.EventoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento-types")
public class EventoTypeController {

    @Autowired
    private EventoTypeRepository eventoTypeRepository;

    @GetMapping
    public List<EventoType> getAllEventoTypes() {
        return eventoTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoType> getEventoTypeById(@PathVariable Long id) {
        EventoType eventoType = eventoTypeRepository.findById(id).orElse(null);
        if (eventoType != null) {
            return ResponseEntity.ok(eventoType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EventoType createEventoType(@RequestBody EventoType eventoType) {
        return eventoTypeRepository.save(eventoType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoType> updateEventoType(@PathVariable Long id, @RequestBody EventoType eventoTypeNovo) {
        EventoType eventoType = eventoTypeRepository.findById(id).orElse(null);
        if (eventoType != null) {
            eventoType.setId(id);
            eventoType.setEventos(eventoTypeNovo.getEventos()); // Atualiza a lista de eventos
            eventoTypeRepository.save(eventoType);
            return ResponseEntity.ok(eventoType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventoType(@PathVariable Long id) {
        EventoType eventoType = eventoTypeRepository.findById(id).orElse(null);
        if (eventoType != null) {
            eventoTypeRepository.delete(eventoType);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
