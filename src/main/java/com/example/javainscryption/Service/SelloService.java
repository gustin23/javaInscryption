package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Sello;
import com.example.javainscryption.Repositories.SelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelloService {
    @Autowired
    SelloRepository selloRepository;
    public Sello crearSello(Sello sello){return selloRepository.save(sello);}
}
