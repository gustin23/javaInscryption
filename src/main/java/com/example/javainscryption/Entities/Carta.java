package com.example.javainscryption.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int costo;

    @ManyToOne
    @JoinColumn(name = "tribu_id")
    private Tribu tribu;

    private int vida;
    private int poder;

    @ManyToMany
    @JoinTable(
            name = "carta_acto",
            joinColumns = @JoinColumn(name = "carta_id"),
            inverseJoinColumns = @JoinColumn(name = "acto_id")
    )
    private List<Acto> actos; // Inicialización aquí


    @ManyToOne
    @JoinColumn(name = "sello_id")
    private Sello sello;

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

    // Sobrescribir equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return id != null && id.equals(carta.id); // Compara por ID
    }

    // Sobrescribir hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}