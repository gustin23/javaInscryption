package com.example.javainscryption.Entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Escriba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany
    private List<Subordinado> subordinado;

    @ManyToMany
    @JoinTable(
            name = "escriba_tribu",
            joinColumns = @JoinColumn(name = "escriba_id"),
            inverseJoinColumns = @JoinColumn(name = "tribu_id")
    )
    private List<Tribu> tribus;

    public List<Tribu> getTribus() {
        return tribus;
    }

    public void setTribus(List<Tribu> tribus) {
        this.tribus = tribus;
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

    public List<Subordinado> getSubordinado() {
        return subordinado;
    }

    public void setSubordinado(List<Subordinado> subordinado) {
        this.subordinado = subordinado;
    }
}
