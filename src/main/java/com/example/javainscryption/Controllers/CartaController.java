package com.example.javainscryption.Controllers;

import com.example.javainscryption.dto.CartaDTO;
import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Service.CartaService;
import com.example.javainscryption.mapper.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    private final CartaService cartaService;
    private final CartaMapper cartaMapper;

    @Autowired
    public CartaController(CartaService cartaService, CartaMapper cartaMapper) {
        this.cartaService = cartaService;
        this.cartaMapper = cartaMapper;
    }

    // Obtener todas las cartas como CartaDTO
    @GetMapping
    public List<CartaDTO> getAllCartas() {
        List<Carta> cartas = cartaService.findAll();
        return cartaMapper.toDtoList(cartas); // Convertimos a DTO usando el mapper
    }

    // Crear cartas a partir de una lista de CartaDTO
    @PostMapping
    public List<CartaDTO> createCarta(@RequestBody List<CartaDTO> cartaDTOs) {
        return cartaDTOs.stream()
                .map(cartaService::createCarta)
                .toList();
    }

    // Eliminar todas las cartas
    @DeleteMapping
    public void deleteAllCartas() {
        cartaService.deleteAll();
    }

    @GetMapping("/mano")
    public List<CartaDTO> getManoAleatoria() {
        List<Carta> manoAleatoria = cartaService.obtenerManoAleatoria();
        return cartaMapper.toDtoList(manoAleatoria);
    }

    @PostMapping("/agregar/{id}")
    public ResponseEntity<String> agregarCartaPorIdYPosicion(
            @PathVariable Long id,
            @RequestParam int posicion) {
        try {
            cartaService.agregarCartaPorIdYPosicion(id, posicion);
            return ResponseEntity.ok("Carta agregada correctamente en la posición " + posicion);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mostrarTablero")
    public ResponseEntity<String> mostrarCartas() {
        String resultado = cartaService.mostrarCartasPosicionadas();
        return ResponseEntity.ok(resultado);
    }
}
