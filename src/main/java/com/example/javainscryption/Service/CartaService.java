package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.Repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaService {
    @Autowired
    CartaRepository cartaRepository;
    public Carta crearCarta(Carta carta){return cartaRepository.save(carta);}
}
