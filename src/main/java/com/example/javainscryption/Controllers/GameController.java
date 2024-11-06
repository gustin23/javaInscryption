package com.example.javainscryption.Controllers;

import com.example.javainscryption.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/iniciar")
    public String iniciarPartida() {
        gameService.iniciarPartida();
        return "¡Partida iniciada con éxito!";
    }
}
