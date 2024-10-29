package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Repositories.CartaRepository;
import com.example.javainscryption.dto.CartaDTO;
import com.example.javainscryption.mapper.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private CartaMapper cartaMapper;

    // Crear una nueva carta
    public Carta crearCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    // Obtener todas las cartas
    public List<Carta> findAll() {
        return cartaRepository.findAll();
    }

    // Buscar una carta por ID
    public Carta findById(Long id) {
        return cartaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carta no encontrada con ID: " + id));
    }

    // Guardar una carta
    public Carta save(Carta carta) {
        return cartaRepository.save(carta);
    }

    // Eliminar todas las cartas
    public void deleteAll() {
        cartaRepository.deleteAll();
    }

    // Convertir y guardar desde DTO
    public Carta saveFromDto(CartaDTO cartaDTO) {
        Carta carta = cartaMapper.toEntity(cartaDTO);
        return save(carta);
    }

    // Convertir a DTO
    public List<CartaDTO> findAllDto() {
        List<Carta> cartas = findAll();
        return cartaMapper.toDtoList(cartas);
    }

    public List<Carta> saveAll(List<Carta> cartas) {
        return cartaRepository.saveAll(cartas);
    }
}
