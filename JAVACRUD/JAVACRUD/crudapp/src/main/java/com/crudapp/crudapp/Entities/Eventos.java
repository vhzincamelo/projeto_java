package com.crudapp.crudapp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity  // Indica que esta classe é uma entidade JPA
@Table(name = "Eventos") // Especifica o nome da tabela no banco de dados
public class Eventos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária auto-incrementada

    private String nome; // Campo de nome do evento

    @ManyToOne // Relacionamento muitos-para-um com EventoType
    @JsonManagedReference // Evita referências cíclicas na serialização JSON
    private EventoType eventoType; // Campo de relacionamento com EventoType

    // Getters e Setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EventoType getEventoType() {
        return eventoType;
    }

    public void setEventoType(EventoType eventoType) {
        this.eventoType = eventoType;
    }
}

    
