package com.example.javainscryption.mapper;

import com.example.javainscryption.dto.SubordinadoDTO;
import com.example.javainscryption.Entities.Subordinado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubordinadoMapper {
    SubordinadoDTO toDto(Subordinado subordinado);
    Subordinado toEntity(SubordinadoDTO subordinadoDTO);
}
