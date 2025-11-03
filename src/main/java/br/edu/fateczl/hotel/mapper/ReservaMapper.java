package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ReservaDTO;
import br.edu.fateczl.hotel.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "id", ignore = true)
    Reserva toEntity(ReservaDTO dto);

    ReservaDTO toDto(Reserva entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ReservaDTO dto, @MappingTarget Reserva entity);

}