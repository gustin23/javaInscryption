package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Repositories.ActoRepository;
import com.example.javainscryption.Repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actos")
public class ActoController {

    @Autowired
    private ActoRepository actoRepository;

    @Autowired
    private CartaRepository cartaRepository;

    @GetMapping
    public List<Acto> getAllActos() {
        return actoRepository.findAll();
    }

    // Asociar cartas a un acto existente
    @PostMapping("/{id}/cartas")
    public Acto addCartasToActo(@PathVariable Long id, @RequestBody List<Long> cartasIds) {
        Optional<Acto> optionalActo = actoRepository.findById(id);
        if (optionalActo.isPresent()) {
            Acto acto = optionalActo.get();
            List<Carta> cartas = cartaRepository.findAllById(cartasIds);
            acto.getCartas().addAll(cartas);
            return actoRepository.save(acto);
        } else {
            throw new RuntimeException("Acto no encontrado");
        }
    }
}
