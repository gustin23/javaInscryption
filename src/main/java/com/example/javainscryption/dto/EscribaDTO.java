package com.example.javainscryption.dto;

import java.util.List;

public class EscribaDTO {
    private Long id;
    private String nombre;
    private List<SubordinadoDTO> subordinado; // Usa un DTO en lugar de la entidad para evitar relaciones circulares
    private List<TribuDTO> tribus;

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

    public List<SubordinadoDTO> getSubordinado() {
        return subordinado;
    }

    public void setSubordinado(List<SubordinadoDTO> subordinado) {
        this.subordinado = subordinado;
    }

    public List<TribuDTO> getTribus() {
        return tribus;
    }

    public void setTribus(List<TribuDTO> tribus) {
        this.tribus = tribus;
    }
}
