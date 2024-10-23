package com.example.javainscryption.Controllers;


import com.example.javainscryption.Entities.Subordinado;
import com.example.javainscryption.Repositories.SubordinadoRepository;
import com.example.javainscryption.Service.SubordinadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subordinados")
public class SubordinadoController {
    @Autowired
    private SubordinadoRepository subordinadoRepository;

    @Autowired
    SubordinadoService subordinadoService;

    @GetMapping
    public List<Subordinado> getAllSubordinados(){return subordinadoRepository.findAll();}

    @PostMapping("subordinado")
    public Subordinado crearSubordinado(@RequestBody Subordinado subordinado){
        Subordinado subordinadoCreado = subordinadoService.crearSubordinado(subordinado);
        return subordinadoCreado;
    }
}
