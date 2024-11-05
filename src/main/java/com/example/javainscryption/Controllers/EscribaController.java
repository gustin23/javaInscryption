package com.example.javainscryption.Controllers;

import com.example.javainscryption.dto.CartaDTO;
import com.example.javainscryption.dto.EscribaDTO;
import com.example.javainscryption.Service.EscribaService;
import com.example.javainscryption.mapper.EscribaMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/escribas")
public class EscribaController {

    private final EscribaService escribaService;
    private final EscribaMapper escribaMapper;

    public EscribaController(EscribaService escribaService, EscribaMapper escribaMapper) {
        this.escribaService = escribaService;
        this.escribaMapper = escribaMapper;
    }

    // Obtener todos los escribas
    @GetMapping
    public ResponseEntity<List<EscribaDTO>> getAllEscribas() {
        List<EscribaDTO> escribas = escribaService.findAll()
                .stream()
                .map(escribaMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(escribas);
    }

    @GetMapping("/{escribaId}/tribus/{tribuId}/cartas")
    public ResponseEntity<List<CartaDTO>> getCartasByEscribaAndTribu(
            @PathVariable Long escribaId,
            @PathVariable Long tribuId) {

        List<CartaDTO> cartas = escribaService.getCartasByEscribaAndTribu(escribaId, tribuId);
        return ResponseEntity.ok(cartas);
    }


    // Obtener un escriba por ID
    @GetMapping("/{id}")
    public ResponseEntity<EscribaDTO> getEscribaById(@PathVariable Long id) {
        EscribaDTO escribaDTO = escribaMapper.toDto(escribaService.findById(id));
        return ResponseEntity.ok(escribaDTO);
    }

    // Obtener un escriba con tribus (y cartas si es necesario)
    @GetMapping("/{id}/tribus")
    public ResponseEntity<EscribaDTO> getEscribaWithTribusAndCartas(@PathVariable Long id) {
        EscribaDTO escribaDTO = escribaMapper.toDto(escribaService.findByIdWithTribus(id));
        return ResponseEntity.ok(escribaDTO);
    }

    // Crear un nuevo escriba
    @PostMapping
    public ResponseEntity<EscribaDTO> createEscriba(@RequestBody EscribaDTO escribaDTO) {
        EscribaDTO createdEscriba = escribaMapper.toDto(escribaService.save(escribaMapper.toEntity(escribaDTO)));
        return ResponseEntity.ok(createdEscriba);
    }

    // Eliminar todos los escribas
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEscribas() {
        escribaService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
