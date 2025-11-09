package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ServicoSolicitadoDTO;
import br.edu.fateczl.hotel.model.Estadia;
import br.edu.fateczl.hotel.model.Servico;
import br.edu.fateczl.hotel.model.ServicoSolicitado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ServicoSolicitadoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadia", source = "estadiaId", qualifiedByName = "mapEstadiaIdToEstadia")
    @Mapping(target = "servico", source = "servicoId", qualifiedByName = "mapServicoIdToServico")
    ServicoSolicitado toEntity(ServicoSolicitadoDTO dto);

    @Mapping(target = "estadiaId", source = "estadia.id")
    @Mapping(target = "servicoId", source = "servico.id")
    ServicoSolicitadoDTO toDto(ServicoSolicitado entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadia", source = "estadiaId", qualifiedByName = "mapEstadiaIdToEstadia")
    @Mapping(target = "servico", source = "servicoId", qualifiedByName = "mapServicoIdToServico")
    void updateEntityFromDto(ServicoSolicitadoDTO dto, @MappingTarget ServicoSolicitado entity);

    @Named("mapEstadiaIdToEstadia")
    default Estadia mapEstadiaIdToEstadia(Long id) {

        if (id == null) return null;

        Estadia estadia = new Estadia();
        estadia.setId(id);

        return estadia;

    }

    @Named("mapServicoIdToServico")
    default Servico mapServicoIdToServico(Long id) {

        if (id == null) return null;

        Servico servico = new Servico();
        servico.setId(id);

        return servico;
    }

}