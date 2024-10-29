package com.example.javainscryption.mapper;

import com.example.javainscryption.Entities.Carta;
import com.example.javainscryption.dto.CartaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartaMapper {
    CartaMapper INSTANCE = Mappers.getMapper(CartaMapper.class);

    // Convertir de Carta a CartaDTO
    @Mapping(source = "tribu.id", target = "tribuId")
    @Mapping(target = "actosIds", expression = "java(carta.getActos().stream().map(acto -> acto.getId()).toList())")
    @Mapping(source = "sello.id", target = "selloId")
    CartaDTO toDto(Carta carta);

    // Convertir de CartaDTO a Carta
    @Mapping(source = "tribuId", target = "tribu.id")
    @Mapping(target = "actos", ignore = true) // Asumimos que se manejará después
    @Mapping(source = "selloId", target = "sello.id")
    Carta toEntity(CartaDTO cartaDTO);

    List<CartaDTO> toDtoList(List<Carta> cartas);
}
