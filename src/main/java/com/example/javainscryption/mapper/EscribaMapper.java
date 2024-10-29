package com.example.javainscryption.mapper;

import com.example.javainscryption.dto.EscribaDTO;
import com.example.javainscryption.Entities.Escriba;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SubordinadoMapper.class, TribuMapper.class})
public interface EscribaMapper {
    EscribaMapper INSTANCE = Mappers.getMapper(EscribaMapper.class);

    // Mapea de Escriba a EscribaDTO
    EscribaDTO toDto(Escriba escriba);

    // Mapea de EscribaDTO a Escriba (si necesitas convertir en ambos sentidos)
    Escriba toEntity(EscribaDTO escribaDTO);
}
