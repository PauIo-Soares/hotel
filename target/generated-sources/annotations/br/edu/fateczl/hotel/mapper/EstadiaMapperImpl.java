package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.EstadiaDTO;
import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.model.Estadia;
import br.edu.fateczl.hotel.model.Quarto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class EstadiaMapperImpl implements EstadiaMapper {

    @Override
    public Estadia toEntity(EstadiaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estadia estadia = new Estadia();

        estadia.setCliente( mapClienteIdToCliente( dto.clienteId() ) );
        estadia.setQuarto( mapQuartoIdToQuarto( dto.quartoId() ) );
        estadia.setDataCheckIn( dto.dataCheckIn() );
        estadia.setDataCheckOut( dto.dataCheckOut() );
        estadia.setValorTotal( dto.valorTotal() );

        return estadia;
    }

    @Override
    public EstadiaDTO toDto(Estadia entity) {
        if ( entity == null ) {
            return null;
        }

        Long clienteId = null;
        Long quartoId = null;
        Long id = null;
        LocalDateTime dataCheckIn = null;
        LocalDateTime dataCheckOut = null;
        BigDecimal valorTotal = null;

        clienteId = entityClienteId( entity );
        quartoId = entityQuartoId( entity );
        id = entity.getId();
        dataCheckIn = entity.getDataCheckIn();
        dataCheckOut = entity.getDataCheckOut();
        valorTotal = entity.getValorTotal();

        EstadiaDTO estadiaDTO = new EstadiaDTO( id, dataCheckIn, dataCheckOut, valorTotal, clienteId, quartoId );

        return estadiaDTO;
    }

    @Override
    public void updateEntityFromDto(EstadiaDTO dto, Estadia entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCliente( mapClienteIdToCliente( dto.clienteId() ) );
        entity.setQuarto( mapQuartoIdToQuarto( dto.quartoId() ) );
        entity.setDataCheckIn( dto.dataCheckIn() );
        entity.setDataCheckOut( dto.dataCheckOut() );
        entity.setValorTotal( dto.valorTotal() );
    }

    private Long entityClienteId(Estadia estadia) {
        if ( estadia == null ) {
            return null;
        }
        Cliente cliente = estadia.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Long id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityQuartoId(Estadia estadia) {
        if ( estadia == null ) {
            return null;
        }
        Quarto quarto = estadia.getQuarto();
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
