package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.ServicoDTO;
import br.edu.fateczl.hotel.mapper.ServicoMapper;
import br.edu.fateczl.hotel.model.Servico;
import br.edu.fateczl.hotel.repository.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoMapper servicoMapper;

    @Transactional
    public String criarServico(ServicoDTO dto) {

        Servico entidade = servicoMapper.toEntity(dto);
        servicoRepository.save(entidade);

        return "Servico criado com sucesso!";

    }

    public ServicoDTO buscarServicoPorId(Long id) {

        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico não encontrado"));

        return servicoMapper.toDto(servico);

    }

    @Transactional
    public String atualizarServico(ServicoDTO dto) {

        Servico servico = servicoRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Servico não encontrado"));

        servicoMapper.updateEntityFromDto(dto, servico);
        servicoRepository.save(servico);

        return "Servico atualizado com sucesso!";

    }

    @Transactional
    public String excluirServico(Long id) {

        servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servicoRepository.deleteById(id);

        return "Servico excluido com sucesso!";

    }

    public List<ServicoDTO> listarServicos() {
        return servicoRepository.findAll().stream().map(servicoMapper::toDto).toList();
    }

}