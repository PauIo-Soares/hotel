package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ClienteDTO;
import br.edu.fateczl.hotel.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDto(Cliente entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ClienteDTO dto, @MappingTarget Cliente entity);

}