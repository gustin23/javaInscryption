package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Tribu;
import com.example.javainscryption.Repositories.TribuRepository;
import com.example.javainscryption.Service.SubordinadoService;
import com.example.javainscryption.Service.TribuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tribus")
public class TribuController {
    @Autowired
    private TribuRepository tribuRepository;

    @Autowired
    TribuService tribuService;

    @GetMapping
    public List<Tribu> getAllTribu(){
        return tribuRepository.findAll();
    }

    @PostMapping
    public List<Tribu> createTribu(@RequestBody List<Tribu> tribus){
        return tribuRepository.saveAll(tribus);
    }

}
