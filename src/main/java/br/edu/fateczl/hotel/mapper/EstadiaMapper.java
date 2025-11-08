package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.EstadiaDTO;
import br.edu.fateczl.hotel.model.Estadia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EstadiaMapper {

    @Mapping(target = "id", ignore = true)
    Estadia toEntity(EstadiaDTO dto);

    EstadiaDTO toDto(Estadia entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EstadiaDTO dto, @MappingTarget Estadia entity);

}