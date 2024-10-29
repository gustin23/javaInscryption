package com.example.javainscryption.mapper;

import com.example.javainscryption.dto.TribuDTO;
import com.example.javainscryption.Entities.Tribu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TribuMapper {
    TribuDTO toDto(Tribu tribu);
    Tribu toEntity(TribuDTO tribuDTO);
}
