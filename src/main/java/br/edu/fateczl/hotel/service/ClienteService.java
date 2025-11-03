package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.ClienteDTO;
import br.edu.fateczl.hotel.mapper.ClienteMapper;
import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional
    public String criarCliente(ClienteDTO dto) {

        Cliente entidade = clienteMapper.toEntity(dto);
        clienteRepository.save(entidade);

        return "Cliente criada com sucesso!";

    }

    public ClienteDTO buscarClientePorId(String cpf) {

        Cliente cliente = clienteRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrada"));

        return clienteMapper.toDto(cliente);

    }

    @Transactional
    public String atualizarCliente(ClienteDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.cpf()).orElseThrow(() -> new RuntimeException("Cliente não encontrada"));
        clienteMapper.updateEntityFromDto(dto, cliente);
        clienteRepository.save(cliente);

        return "Cliente atualizada com sucesso!";

    }

    @Transactional
    public String excluirCliente(String cpf) {

        clienteRepository.deleteById(cpf);

        return "Cliente excluida com sucesso!";

    }

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(clienteMapper::toDto).toList();
    }

}