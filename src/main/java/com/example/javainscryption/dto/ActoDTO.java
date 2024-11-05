package com.example.javainscryption.dto;

import java.util.List;

public class ActoDTO {
    private Long id;
    private String nombre;
    private List<CartaDTO> carta; // Solo los IDs de las cartas relacionadas

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CartaDTO> getCarta() {
        return carta;
    }

    public void setCarta(List<CartaDTO> carta) {
        this.carta = carta;
    }
}
