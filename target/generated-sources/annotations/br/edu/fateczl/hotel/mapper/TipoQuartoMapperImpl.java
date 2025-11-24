package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.TipoQuartoDTO;
import br.edu.fateczl.hotel.model.TipoQuarto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class TipoQuartoMapperImpl implements TipoQuartoMapper {

    @Override
    public TipoQuarto toEntity(TipoQuartoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoQuarto tipoQuarto = new TipoQuarto();

        tipoQuarto.setNome( dto.nome() );
        tipoQuarto.setValorDiaria( dto.valorDiaria() );

        return tipoQuarto;
    }

    @Override
    public TipoQuartoDTO toDto(TipoQuarto entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        BigDecimal valorDiaria = null;

        id = entity.getId();
        nome = entity.getNome();
        valorDiaria = entity.getValorDiaria();

        TipoQuartoDTO tipoQuartoDTO = new TipoQuartoDTO( id, nome, valorDiaria );

        return tipoQuartoDTO;
    }

    @Override
    public void updateEntityFromDto(TipoQuartoDTO dto, TipoQuarto entity) {
        if ( dto == null ) {
            return;
        }

        entity.setNome( dto.nome() );
        entity.setValorDiaria( dto.valorDiaria() );
    }
}
