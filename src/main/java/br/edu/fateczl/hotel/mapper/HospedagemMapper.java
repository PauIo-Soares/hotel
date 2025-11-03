package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.HospedagemDTO;
import br.edu.fateczl.hotel.model.Hospedagem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HospedagemMapper {

    @Mapping(target = "id", ignore = true)
    Hospedagem toEntity(HospedagemDTO dto);

    HospedagemDTO toDto(Hospedagem entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HospedagemDTO dto, @MappingTarget Hospedagem entity);

}