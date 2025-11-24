package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ReservaDTO;
import br.edu.fateczl.hotel.enums.StatusReserva;
import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.model.Reserva;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public Reserva toEntity(ReservaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setCliente( mapClienteIdToCliente( dto.clienteId() ) );
        reserva.setQuarto( mapQuartoIdToQuarto( dto.quartoId() ) );
        reserva.setDataReserva( dto.dataReserva() );
        reserva.setDataInicio( dto.dataInicio() );
        reserva.setQuantidadeDias( dto.quantidadeDias() );
        reserva.setStatus( dto.status() );

        return reserva;
    }

    @Override
    public ReservaDTO toDto(Reserva entity) {
        if ( entity == null ) {
            return null;
        }

        Long clienteId = null;
        Long quartoId = null;
        Long id = null;
        LocalDate dataReserva = null;
        LocalDate dataInicio = null;
        Integer quantidadeDias = null;
        StatusReserva status = null;

        clienteId = entityClienteId( entity );
        quartoId = entityQuartoId( entity );
        id = entity.getId();
        dataReserva = entity.getDataReserva();
        dataInicio = entity.getDataInicio();
        quantidadeDias = entity.getQuantidadeDias();
        status = entity.getStatus();

        ReservaDTO reservaDTO = new ReservaDTO( id, dataReserva, dataInicio, quantidadeDias, clienteId, quartoId, status );

        return reservaDTO;
    }

    @Override
    public void updateEntityFromDto(ReservaDTO dto, Reserva entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCliente( mapClienteIdToCliente( dto.clienteId() ) );
        entity.setQuarto( mapQuartoIdToQuarto( dto.quartoId() ) );
        entity.setDataReserva( dto.dataReserva() );
        entity.setDataInicio( dto.dataInicio() );
        entity.setQuantidadeDias( dto.quantidadeDias() );
        entity.setStatus( dto.status() );
    }

    private Long entityClienteId(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }
        Cliente cliente = reserva.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Long id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityQuartoId(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }
        Quarto quarto = reserva.getQuarto();
        if ( quarto == null ) {
            return null;
        }
        Long id = quarto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
