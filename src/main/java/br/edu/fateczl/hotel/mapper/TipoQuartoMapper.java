package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.TipoQuartoDTO;
import br.edu.fateczl.hotel.model.TipoQuarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TipoQuartoMapper {

    @Mapping(target = "id", ignore = true)
    TipoQuarto toEntity(TipoQuartoDTO dto);

    TipoQuartoDTO toDto(TipoQuarto entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TipoQuartoDTO dto, @MappingTarget TipoQuarto entity);

}