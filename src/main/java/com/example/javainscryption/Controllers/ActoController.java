package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.Repositories.ActoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actos")
public class ActoController {
    @Autowired
    private ActoRepository actoRepository;

    @PostMapping
    public List<Acto> createActo(@RequestBody List<Acto> actos){
        return actoRepository.saveAll(actos);
    }

    @GetMapping
    public List<Acto> getAllProductos(){
        return actoRepository.findAll();
    }
}
