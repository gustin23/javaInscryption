package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class CartaController {
    @Autowired
    private CartaRepository cartaRepository;

    @GetMapping
    public List<Carta> getAllCartas(){return cartaRepository.findAll();}

    @PostMapping
    public List<Carta> createCarta(@RequestBody List<Carta> cartas) { return cartaRepository.saveAll(cartas); }

    @DeleteMapping
    public void deleteAllCartas() {
        cartaRepository.deleteAll();
    }

}
