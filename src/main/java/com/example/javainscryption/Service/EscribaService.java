package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Escriba;
import com.example.javainscryption.Repositories.EscribaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscribaService {
    @Autowired
    EscribaRepository escribaRepository;
    public Escriba crearEscriba(Escriba escriba){return escribaRepository.save(escriba);}
}
