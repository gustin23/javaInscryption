package com.example.javainscryption.Controllers;


import com.example.javainscryption.Entities.Escriba;
import com.example.javainscryption.Repositories.EscribaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escribas")
public class EscribaController {
    @Autowired
    private EscribaRepository escribaRepository;

    @GetMapping
    public List<Escriba> getAllEscribas(){return escribaRepository.findAll();}

    @GetMapping("/{id}")
    public Escriba getEscribaById(@PathVariable Long id){
        return escribaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el Escriba con el ID: " + id));
    }

    @GetMapping("/{id}/tribus")
    public Escriba getEscribaWithTribusAndCartas(@PathVariable Long id) {
        Escriba escriba = escribaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escriba no encontrado con id " + id));

        // Devuelve el escriba con las tribus y las cartas de cada tribu
        return escriba;
    }

    @PostMapping
    public Escriba createEscriba(@RequestBody Escriba escriba) { return escribaRepository.save(escriba); }

    @DeleteMapping
    public void deleteAllEscribas() {
        escribaRepository.deleteAll();
    }

}
