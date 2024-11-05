package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.Repositories.ActoRepository;
import com.example.javainscryption.mapper.ActoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActoService {

    @Autowired
    private ActoRepository actoRepository;

    @Autowired
    private ActoMapper actoMapper;

    // Crear un nuevo escriba
    public Acto crearActo(Acto acto) {
        return actoRepository.save(acto);
    }

    // Obtener todos los escribas
    public List<Acto> findAll() {
        return actoRepository.findAll();
    }

}
