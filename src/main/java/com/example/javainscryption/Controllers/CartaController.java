package com.example.javainscryption.Controllers;

import com.example.javainscryption.dto.CartaDTO;
import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Service.CartaService;
import com.example.javainscryption.mapper.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CartaDTO> createCarta(@RequestBody List<CartaDTO> cartasDTO) {
        // Convertimos de DTO a entidad, guardamos y luego convertimos el resultado a DTO
        List<Carta> cartas = cartasDTO.stream()
                .map(cartaMapper::toEntity)
                .toList();
        List<Carta> savedCartas = cartaService.saveAll(cartas);
        return cartaMapper.toDtoList(savedCartas); // Devolvemos como lista de DTOs
    }

    // Eliminar todas las cartas
    @DeleteMapping
    public void deleteAllCartas() {
        cartaService.deleteAll();
    }
}
