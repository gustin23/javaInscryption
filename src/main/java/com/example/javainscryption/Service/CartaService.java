package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Repositories.ActoRepository;
import com.example.javainscryption.Repositories.CartaRepository;
import com.example.javainscryption.dto.CartaDTO;
import com.example.javainscryption.mapper.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CartaService {

    private final CartaRepository cartaRepository;
    private final ActoRepository actoRepository;
    private final CartaMapper cartaMapper;

    private Carta[] cartas = new Carta[4];
    private List<Carta> cartasPermitidas = new ArrayList<>();
    private List<Carta> manoActual;

    public CartaDTO createCarta(CartaDTO cartaDTO) {
        Carta carta = cartaMapper.toEntity(cartaDTO);

        // Cargar los actos usando los IDs de actos
        List<Acto> actos = actoRepository.findAllById(cartaDTO.getActosIds());
        carta.setActos(actos);

        Carta savedCarta = cartaRepository.save(carta);
        return cartaMapper.toDto(savedCarta);
    }

    @Autowired
    public CartaService(CartaRepository cartaRepository, ActoRepository actoRepository, CartaMapper cartaMapper) {
        this.cartaRepository = cartaRepository;
        this.actoRepository = actoRepository;
        this.cartaMapper = cartaMapper;
    }

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

    public List<CartaDTO> getAllCartas() {
        return cartaMapper.toDtoList(cartaRepository.findAll());
    }

    public List<Carta> saveAll(List<Carta> cartas) {
        return cartaRepository.saveAll(cartas);
    }

    public List<Carta> obtenerManoAleatoria() {
        List<Carta> todasLasCartas = cartaRepository.findAll();

        if (todasLasCartas.size() < 4) {
            throw new RuntimeException("No hay suficientes cartas para obtener una mano de 4 cartas.");
        }

        Collections.shuffle(todasLasCartas);

        manoActual = todasLasCartas.subList(0, 4);

        return manoActual;
    }

    public void agregarCartaPorIdYPosicion(Long cartaId, int posicion) {
        if (posicion < 0 || posicion >= cartas.length) {
            throw new IllegalArgumentException("Posición inválida. Debe estar entre 0 y 3.");
        }

        // Verificar si la posición ya está ocupada
        if (cartas[posicion] != null) {
            throw new IllegalStateException("La posición " + posicion + " ya está ocupada.");
        }

        if (manoActual == null || manoActual.isEmpty()) {
            throw new IllegalStateException("No se ha generado una mano aleatoria. Use obtenerManoAleatoria primero.");
        }

        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new RuntimeException("Carta no encontrada con ID: " + cartaId));

        // Verificar si la carta está en la mano actual
        if (!manoActual.contains(carta)) {
            throw new IllegalArgumentException("La carta no pertenece a la mano actual generada.");
        }

        cartas[posicion] = carta;
    }


    public String mostrarCartasPosicionadas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                String infoCarta = "Posición " + i + ": " + cartas[i].getNombre();
                System.out.println(infoCarta); // Imprime en consola
                sb.append(infoCarta).append("\n");
            } else {
                String infoCarta = "Posición " + i + ": Vacía";
                System.out.println(infoCarta);
                sb.append(infoCarta).append("\n");
            }
        }
        return sb.toString();
    }

}
