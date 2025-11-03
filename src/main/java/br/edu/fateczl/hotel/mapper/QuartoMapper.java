package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.model.Quarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuartoMapper {

    @Mapping(target = "id", ignore = true)
    Quarto toEntity(QuartoDTO dto);

    QuartoDTO toDto(Quarto entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(QuartoDTO dto, @MappingTarget Quarto entity);

}