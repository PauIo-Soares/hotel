package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ServicoDTO;
import br.edu.fateczl.hotel.model.Servico;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ServicoMapperImpl implements ServicoMapper {

    @Override
    public Servico toEntity(ServicoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Servico servico = new Servico();

        servico.setNome( dto.nome() );
        servico.setDescricao( dto.descricao() );
        servico.setValor( dto.valor() );

        return servico;
    }

    @Override
    public ServicoDTO toDto(Servico entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String descricao = null;
        BigDecimal valor = null;

        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        valor = entity.getValor();

        ServicoDTO servicoDTO = new ServicoDTO( id, nome, descricao, valor );

        return servicoDTO;
    }

    @Override
    public void updateEntityFromDto(ServicoDTO dto, Servico entity) {
        if ( dto == null ) {
            return;
        }

        entity.setNome( dto.nome() );
        entity.setDescricao( dto.descricao() );
        entity.setValor( dto.valor() );
    }
}
