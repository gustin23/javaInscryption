package com.example.javainscryption.Controllers;
import com.example.javainscryption.Service.CartaService;
import com.example.javainscryption.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final CartaService cartaService;

    @Autowired
    public GameController(GameService gameService, CartaService cartaService) {
        this.gameService = gameService;
        this.cartaService = cartaService;
    }

    @GetMapping("/iniciar")
    public String iniciarPartida() {
        gameService.iniciarPartida();
        return "¡Partida iniciada con éxito!";
    }

}
