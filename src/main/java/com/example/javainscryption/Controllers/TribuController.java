package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Tribu;
import com.example.javainscryption.Service.TribuService;
import com.example.javainscryption.dto.TribuDTO;
import com.example.javainscryption.mapper.TribuMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tribus")
public class TribuController {

    private final TribuService tribuService;
    private final TribuMapper tribuMapper;

    public TribuController(TribuService tribuService, TribuMapper tribuMapper) {
        this.tribuService = tribuService;
        this.tribuMapper = tribuMapper;
    }

    @GetMapping
    public ResponseEntity<List<TribuDTO>> getAllEscribas() {
        List<TribuDTO> tribus = tribuService.findAll()
                .stream()
                .map(tribuMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tribus);
    }

}
