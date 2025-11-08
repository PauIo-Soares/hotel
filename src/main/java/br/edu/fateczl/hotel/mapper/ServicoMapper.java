package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ServicoDTO;
import br.edu.fateczl.hotel.model.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    @Mapping(target = "id", ignore = true)
    Servico toEntity(ServicoDTO dto);

    ServicoDTO toDto(Servico entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ServicoDTO dto, @MappingTarget Servico entity);

}