package com.example.javainscryption.mapper;

import com.example.javainscryption.Entities.Acto;
import com.example.javainscryption.dto.ActoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CartaMapper.class})
public interface ActoMapper {
    ActoMapper INSTANCE = Mappers.getMapper(ActoMapper.class);

    ActoDTO toDto(Acto acto);

    Acto toEntity(ActoDTO actoDTO);
}
