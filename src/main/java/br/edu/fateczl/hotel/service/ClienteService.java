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

    public ClienteDTO buscarClientePorCpf(String cpf) {

        Cliente cliente = clienteRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return clienteMapper.toDto(cliente);

    }

    @Transactional
    public String atualizarCliente(ClienteDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.cpf()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteMapper.updateEntityFromDto(dto, cliente);
        clienteRepository.save(cliente);

        return "Cliente atualizado com sucesso!";

    }

    @Transactional
    public String excluirClientePorCpf(String cpf) {

        clienteRepository.deleteByCpf(cpf);

        return "Cliente excluido com sucesso!";

    }

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(clienteMapper::toDto).toList();
    }

}