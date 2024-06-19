package com.crudapp.crudapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.crudapp.Entities.EventoType;

public interface EventoTypeRepository extends JpaRepository<EventoType, Long> {
    
}
