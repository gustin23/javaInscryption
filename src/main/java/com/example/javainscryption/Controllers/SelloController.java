package com.example.javainscryption.Controllers;

import com.example.javainscryption.Entities.Sello;
import com.example.javainscryption.Repositories.SelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellos")
public class SelloController {
    @Autowired
    private SelloRepository selloRepository;

    @GetMapping
    public List<Sello> getAllSellos(){return selloRepository.findAll();}

    @PostMapping
    public List<Sello> createSello(@RequestBody List<Sello> sellos){
        return selloRepository.saveAll(sellos);
    }
}
