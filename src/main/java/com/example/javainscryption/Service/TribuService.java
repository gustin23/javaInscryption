package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Tribu;
import com.example.javainscryption.Repositories.TribuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TribuService {
    @Autowired
    TribuRepository tribuRepository;
    public Tribu crearTribu(Tribu tribu){return tribuRepository.save(tribu);}
}
