package com.example.javainscryption.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tribu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String efecto;

    @ManyToMany(mappedBy = "tribus")
    @JsonBackReference
    private List<Escriba> escribas;

    @OneToMany(mappedBy = "tribu")
    @JsonManagedReference // Controla la serialización de las cartas
    private List<Carta> cartas;

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Escriba> getEscribas() {
        return escribas;
    }

    public void setEscribas(List<Escriba> escribas) {
        this.escribas = escribas;
    }

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

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
}
