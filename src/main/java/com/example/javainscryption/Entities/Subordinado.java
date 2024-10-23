package com.example.javainscryption.Entities;



import com.example.javainscryption.Entities.Subordinado;
import com.example.javainscryption.Repositories.SubordinadoRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Subordinado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "escriba_id")
    private Escriba escriba;

    @ManyToOne
    @JoinColumn(name = "acto_id")
    private Acto acto;

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

    public Escriba getEscriba() {
        return escriba;
    }

    public void setEscriba(Escriba escriba) {
        this.escriba = escriba;
    }

    public Acto getActo() {
        return acto;
    }

    public void setActo(Acto acto) {
        this.acto = acto;
    }
}
