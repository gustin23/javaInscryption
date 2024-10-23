package com.example.javainscryption.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int costo;

    @ManyToOne
    @JoinColumn(name = "tribu_id")
    @JsonBackReference
    private Tribu tribu;

    private int vida;
    private int poder;

    @ManyToMany
    @JoinTable(
            name = "carta_acto",
            joinColumns = @JoinColumn(name = "carta_id"),
            inverseJoinColumns = @JoinColumn(name = "acto_id")
    )
    private List<Acto> actos;


    @ManyToOne
    @JoinColumn(name = "sello_id")
    private Sello sello;

    @JsonManagedReference
    public List<Acto> getActos() {
        return actos;
    }

    public void setActos(List<Acto> actos) {
        this.actos = actos;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Tribu getTribu() {
        return tribu;
    }

    public void setTribu(Tribu tribu) {
        this.tribu = tribu;
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



    public Sello getSello() {
        return sello;
    }

    public void setSello(Sello sello) {
        this.sello = sello;
    }
}