package com.crudapp.crudapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.crudapp.Entities.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
    
}
