package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Carta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.javainscryption.Service.GameState;
import java.util.List;

@Service
public class GameService {

    private final CartaService cartaService;

    @Autowired
    public GameService(CartaService cartaService) {
        this.cartaService = cartaService;
    }

    // Lógica para iniciar una partida
    public void iniciarPartida() {
        // Obtener una mano inicial de 4 cartas aleatorias
        List<Carta> manoInicial = cartaService.obtenerManoAleatoria();

        int vidaJugador = 20;

        // Mostrar las cartas de la mano inicial
        System.out.println("Mano inicial: ");
        manoInicial.forEach(carta -> System.out.println("Carta: " + carta.getNombre() + " ID: " + carta.getId()));

        // Configurar el estado del juego
        GameState estadoJuego = new GameState();
        estadoJuego.setMano(manoInicial);
        estadoJuego.setVidaJugador(vidaJugador);

    }
}
