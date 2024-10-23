package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Subordinado;
import com.example.javainscryption.Repositories.SubordinadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubordinadoService {
    @Autowired
    SubordinadoRepository subordinadoRepository;
    public Subordinado crearSubordinado(Subordinado subordinado){return subordinadoRepository.save(subordinado);}
}
