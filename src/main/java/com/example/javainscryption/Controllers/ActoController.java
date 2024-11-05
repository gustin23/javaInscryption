package com.example.javainscryption.Controllers;

import com.example.javainscryption.Service.ActoService;
import com.example.javainscryption.dto.ActoDTO;
import com.example.javainscryption.mapper.ActoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actos")
public class ActoController {

    private final ActoService actoService;
    private final ActoMapper actoMapper;

    public ActoController(ActoService actoService, ActoMapper actoMapper) {
        this.actoService = actoService;
        this.actoMapper = actoMapper;
    }

    @GetMapping
    public ResponseEntity<List<ActoDTO>> getAllActos() {
        List<ActoDTO> actos = actoService.findAll()
                .stream()
                .map(actoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(actos);
    }
}
