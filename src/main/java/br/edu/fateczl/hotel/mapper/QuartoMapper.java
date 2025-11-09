package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.model.TipoQuarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface QuartoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoQuarto", source = "tipoQuartoId", qualifiedByName = "mapTipoQuartoIdToTipoQuarto")
    Quarto toEntity(QuartoDTO dto);

    @Mapping(target = "tipoQuartoId", source = "tipoQuarto.id")
    QuartoDTO toDto(Quarto entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoQuarto", source = "tipoQuartoId", qualifiedByName = "mapTipoQuartoIdToTipoQuarto")
    void updateEntityFromDto(QuartoDTO dto, @MappingTarget Quarto entity);

    @Named("mapTipoQuartoIdToTipoQuarto")
    default TipoQuarto mapTipoQuartoIdToTipoQuarto(Long id) {

        if (id == null) return null;

        TipoQuarto tipo = new TipoQuarto();
        tipo.setId(id);

        return tipo;

    }

}