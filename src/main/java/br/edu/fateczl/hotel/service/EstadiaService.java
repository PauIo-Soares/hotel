package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.EstadiaDTO;
import br.edu.fateczl.hotel.mapper.EstadiaMapper;
import br.edu.fateczl.hotel.model.Estadia;
import br.edu.fateczl.hotel.repository.EstadiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadiaService {

    @Autowired
    private EstadiaRepository estadiaRepository;

    @Autowired
    private EstadiaMapper estadiaMapper;

    @Transactional
    public String criarEstadia(EstadiaDTO dto) {

        Estadia entidade = estadiaMapper.toEntity(dto);
        estadiaRepository.save(entidade);

        return "Estadia criada com sucesso!";

    }

    public EstadiaDTO buscarEstadiaPorId(Long id) {

        Estadia estadia = estadiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estadia não encontrada"));

        return estadiaMapper.toDto(estadia);

    }

    @Transactional
    public String atualizarEstadia(EstadiaDTO dto) {

        Estadia estadia = estadiaRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Estadia não encontrada"));

        estadiaMapper.updateEntityFromDto(dto, estadia);
        estadiaRepository.save(estadia);

        return "Estadia atualizada com sucesso!";

    }

    @Transactional
    public String excluirEstadia(Long id) {

        estadiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estadia não encontrada"));

        estadiaRepository.deleteById(id);

        return "Estadia excluida com sucesso!";

    }

    public List<EstadiaDTO> listarEstadia() {
        return estadiaRepository.findAll().stream().map(estadiaMapper::toDto).toList();
    }

}