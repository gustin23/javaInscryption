package com.example.javainscryption.dto;

import java.util.List;

public class CartaDTO {
    private Long id;
    private String nombre;
    private int costo;
    private Long tribuId; // Almacena solo el ID de la tribu
    private int vida;
    private int poder;
    private List<Long> actosIds; // Almacena los IDs de los actos
    private Long selloId; // Almacena solo el ID del sello

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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Long getTribuId() {
        return tribuId;
    }

    public void setTribuId(Long tribuId) {
        this.tribuId = tribuId;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public List<Long> getActosIds() {
        return actosIds;
    }

    public void setActosIds(List<Long> actosIds) {
        this.actosIds = actosIds;
    }

    public Long getSelloId() {
        return selloId;
    }

    public void setSelloId(Long selloId) {
        this.selloId = selloId;
    }
}
