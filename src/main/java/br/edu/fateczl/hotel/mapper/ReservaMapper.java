package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ReservaDTO;
import br.edu.fateczl.hotel.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.model.Quarto;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapClienteIdToCliente")
    @Mapping(target = "quarto", source = "quartoId", qualifiedByName = "mapQuartoIdToQuarto")
    Reserva toEntity(ReservaDTO dto);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "quartoId", source = "quarto.id")
    ReservaDTO toDto(Reserva entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapClienteIdToCliente")
    @Mapping(target = "quarto", source = "quartoId", qualifiedByName = "mapQuartoIdToQuarto")
    void updateEntityFromDto(ReservaDTO dto, @MappingTarget Reserva entity);

    @Named("mapClienteIdToCliente")
    default Cliente mapClienteIdToCliente(Long id) {

        if (id == null) return null;

        Cliente cliente = new Cliente();
        cliente.setId(id);

        return cliente;

    }

    @Named("mapQuartoIdToQuarto")
    default Quarto mapQuartoIdToQuarto(Long id) {

        if (id == null) return null;

        Quarto quarto = new Quarto();
        quarto.setId(id);

        return quarto;

    }

}