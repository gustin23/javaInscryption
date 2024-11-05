package com.example.javainscryption.mapper;

import com.example.javainscryption.Entities.Tribu;
import com.example.javainscryption.dto.TribuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TribuMapper {
    TribuMapper INSTANCE = Mappers.getMapper(TribuMapper.class);

    TribuDTO toDto(Tribu tribu);
    Tribu toEntity(TribuDTO tribuDTO);
}
