package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Escriba;
import com.example.javainscryption.Repositories.EscribaRepository;
import com.example.javainscryption.mapper.EscribaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscribaService {

    @Autowired
    private EscribaRepository escribaRepository;

    @Autowired
    private EscribaMapper escribaMapper;

    // Crear un nuevo escriba
    public Escriba crearEscriba(Escriba escriba) {
        return escribaRepository.save(escriba);
    }

    // Obtener todos los escribas
    public List<Escriba> findAll() {
        return escribaRepository.findAll();
    }

    // Buscar un escriba por ID
    public Escriba findById(Long id) {
        return escribaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escriba no encontrado con ID: " + id));
    }

    // Buscar un escriba por ID y cargar tribus
    public Escriba findByIdWithTribus(Long id) {
        Escriba escriba = findById(id);
        // Aquí puedes agregar la lógica necesaria para cargar las tribus si es necesario
        // Por ejemplo, si las tribus están en una relación @ManyToMany, se cargarían automáticamente si está configurado correctamente.
        return escriba;
    }

    // Guardar un escriba (puedes crear un metodo separado si necesitas realizar mapeo)
    public Escriba save(Escriba escriba) {
        return escribaRepository.save(escriba);
    }

    // Eliminar todos los escribas
    public void deleteAll() {
        escribaRepository.deleteAll();
    }
}
