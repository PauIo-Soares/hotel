package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.model.TipoQuarto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class QuartoMapperImpl implements QuartoMapper {

    @Override
    public Quarto toEntity(QuartoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Quarto quarto = new Quarto();

        quarto.setTipoQuarto( mapTipoQuartoIdToTipoQuarto( dto.tipoQuartoId() ) );
        quarto.setNumero( dto.numero() );
        quarto.setAndar( dto.andar() );
        quarto.setDescricao( dto.descricao() );

        return quarto;
    }

    @Override
    public QuartoDTO toDto(Quarto entity) {
        if ( entity == null ) {
            return null;
        }

        Long tipoQuartoId = null;
        Long id = null;
        Integer numero = null;
        Integer andar = null;
        String descricao = null;

        tipoQuartoId = entityTipoQuartoId( entity );
        id = entity.getId();
        numero = entity.getNumero();
        andar = entity.getAndar();
        descricao = entity.getDescricao();

        QuartoDTO quartoDTO = new QuartoDTO( id, numero, andar, descricao, tipoQuartoId );

        return quartoDTO;
    }

    @Override
    public void updateEntityFromDto(QuartoDTO dto, Quarto entity) {
        if ( dto == null ) {
            return;
        }

        entity.setTipoQuarto( mapTipoQuartoIdToTipoQuarto( dto.tipoQuartoId() ) );
        entity.setNumero( dto.numero() );
        entity.setAndar( dto.andar() );
        entity.setDescricao( dto.descricao() );
    }

    private Long entityTipoQuartoId(Quarto quarto) {
        if ( quarto == null ) {
            return null;
        }
        TipoQuarto tipoQuarto = quarto.getTipoQuarto();
        if ( tipoQuarto == null ) {
            return null;
        }
        Long id = tipoQuarto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
