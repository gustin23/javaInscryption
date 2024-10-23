package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.Repositories.ActoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActoService {
    @Autowired
    ActoRepository actoRepository;
    public Acto crearActo(Acto acto){return actoRepository.save(acto);}
}
