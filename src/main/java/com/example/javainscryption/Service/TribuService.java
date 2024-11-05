package com.example.javainscryption.Service;

import com.example.javainscryption.Entities.Escriba;
import com.example.javainscryption.Entities.Tribu;
import com.example.javainscryption.Repositories.TribuRepository;
import com.example.javainscryption.dto.TribuDTO;
import com.example.javainscryption.mapper.TribuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TribuService {
    @Autowired
    private final TribuRepository tribuRepository;

    @Autowired
    private final TribuMapper tribuMapper;

    @Autowired
    public TribuService(TribuRepository tribuRepository, TribuMapper tribuMapper) {
        this.tribuRepository = tribuRepository;
        this.tribuMapper = tribuMapper;
    }

    public List<Tribu> findAll() {
        return tribuRepository.findAll();
    }

    // Crear una nueva tribu
    public TribuDTO createTribu(TribuDTO tribuDTO) {
        Tribu tribu = tribuMapper.toEntity(tribuDTO);
        Tribu savedTribu = tribuRepository.save(tribu);
        return tribuMapper.toDto(savedTribu);
    }

    // Obtener todas las tribus
    public List<TribuDTO> getAllTribus() {
        return tribuRepository.findAll().stream()
                .map(tribuMapper::toDto)
                .collect(Collectors.toList());
    }

    // Obtener una tribu por ID
    public TribuDTO getTribuById(Long id) {
        Tribu tribu = tribuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tribu no encontrada con id: " + id));
        return tribuMapper.toDto(tribu);
    }

    // Actualizar una tribu
    public TribuDTO updateTribu(Long id, TribuDTO tribuDTO) {
        Optional<Tribu> tribuOptional = tribuRepository.findById(id);
        if (tribuOptional.isPresent()) {
            Tribu tribu = tribuOptional.get();
            tribu.setNombre(tribuDTO.getNombre());
            tribu.setEfecto(tribuDTO.getEfecto());
            Tribu updatedTribu = tribuRepository.save(tribu);
            return tribuMapper.toDto(updatedTribu);
        } else {
            throw new RuntimeException("Tribu no encontrada con id: " + id);
        }
    }

    // Eliminar una tribu por su ID
    public void deleteTribuById(Long id) {
        if (tribuRepository.existsById(id)) {
            tribuRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tribu no encontrada con id: " + id);
        }
    }

}
