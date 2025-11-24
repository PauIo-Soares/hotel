package br.edu.fateczl.hotel.mapper;

import br.edu.fateczl.hotel.dto.ClienteDTO;
import br.edu.fateczl.hotel.model.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-24T01:23:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCpf( dto.cpf() );
        cliente.setNome( dto.nome() );
        cliente.setTelefone( dto.telefone() );
        cliente.setCidadeOrigem( dto.cidadeOrigem() );

        return cliente;
    }

    @Override
    public ClienteDTO toDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String cpf = null;
        String nome = null;
        String telefone = null;
        String cidadeOrigem = null;

        id = entity.getId();
        cpf = entity.getCpf();
        nome = entity.getNome();
        telefone = entity.getTelefone();
        cidadeOrigem = entity.getCidadeOrigem();

        ClienteDTO clienteDTO = new ClienteDTO( id, cpf, nome, telefone, cidadeOrigem );

        return clienteDTO;
    }

    @Override
    public void updateEntityFromDto(ClienteDTO dto, Cliente entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCpf( dto.cpf() );
        entity.setNome( dto.nome() );
        entity.setTelefone( dto.telefone() );
        entity.setCidadeOrigem( dto.cidadeOrigem() );
    }
}
