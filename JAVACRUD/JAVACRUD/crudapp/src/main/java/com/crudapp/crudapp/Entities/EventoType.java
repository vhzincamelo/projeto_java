package com.crudapp.crudapp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "EventoType") // Especifica o nome da tabela no banco de dados
public class EventoType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária auto-incrementada

    // Relacionamento um-para-muitos com a entidade Eventos
    @OneToMany
    @JoinColumn(name = "evento_type_id") // Nome da coluna na tabela Eventos que referencia EventoType
    @JsonManagedReference // Evita referências cíclicas na serialização JSON
    private List<Eventos> eventos; // Lista de eventos associados a este tipo de evento

    // Getters e Setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }
    
}
