package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ServicoSolicitadoDTO;
import br.edu.fateczl.hotel.model.Estadia;
import br.edu.fateczl.hotel.model.Servico;
import br.edu.fateczl.hotel.model.ServicoSolicitado;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ServicoSolicitadoMapperImpl implements ServicoSolicitadoMapper {

    @Override
    public ServicoSolicitado toEntity(ServicoSolicitadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServicoSolicitado servicoSolicitado = new ServicoSolicitado();

        servicoSolicitado.setEstadia( mapEstadiaIdToEstadia( dto.estadiaId() ) );
        servicoSolicitado.setServico( mapServicoIdToServico( dto.servicoId() ) );
        servicoSolicitado.setQuantidade( dto.quantidade() );
        servicoSolicitado.setValorTotal( dto.valorTotal() );

        return servicoSolicitado;
    }

    @Override
    public ServicoSolicitadoDTO toDto(ServicoSolicitado entity) {
        if ( entity == null ) {
            return null;
        }

        Long estadiaId = null;
        Long servicoId = null;
        Long id = null;
        Integer quantidade = null;
        BigDecimal valorTotal = null;

        estadiaId = entityEstadiaId( entity );
        servicoId = entityServicoId( entity );
        id = entity.getId();
        quantidade = entity.getQuantidade();
        valorTotal = entity.getValorTotal();

        ServicoSolicitadoDTO servicoSolicitadoDTO = new ServicoSolicitadoDTO( id, quantidade, valorTotal, estadiaId, servicoId );

        return servicoSolicitadoDTO;
    }

    @Override
    public void updateEntityFromDto(ServicoSolicitadoDTO dto, ServicoSolicitado entity) {
        if ( dto == null ) {
            return;
        }

        entity.setEstadia( mapEstadiaIdToEstadia( dto.estadiaId() ) );
        entity.setServico( mapServicoIdToServico( dto.servicoId() ) );
        entity.setQuantidade( dto.quantidade() );
        entity.setValorTotal( dto.valorTotal() );
    }

    private Long entityEstadiaId(ServicoSolicitado servicoSolicitado) {
        if ( servicoSolicitado == null ) {
            return null;
        }
        Estadia estadia = servicoSolicitado.getEstadia();
        if ( estadia == null ) {
            return null;
        }
        Long id = estadia.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityServicoId(ServicoSolicitado servicoSolicitado) {
        if ( servicoSolicitado == null ) {
            return null;
        }
        Servico servico = servicoSolicitado.getServico();
        if ( servico == null ) {
            return null;
        }
        Long id = servico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
