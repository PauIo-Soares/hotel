package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.mapper.QuartoMapper;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private QuartoMapper quartoMapper;

    @Transactional
    public String criarQuarto(QuartoDTO dto) {

        Quarto entidade = quartoMapper.toEntity(dto);
        quartoRepository.save(entidade);

        return "Quarto criada com sucesso!";

    }

    public QuartoDTO buscarQuartoPorId(Long id) {

        Quarto quarto = quartoRepository.findById(id).orElseThrow(() -> new RuntimeException("Quarto não encontrada"));

        return quartoMapper.toDto(quarto);

    }

    @Transactional
    public String atualizarQuarto(QuartoDTO dto) {

        Quarto quarto = quartoRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Quarto não encontrada"));
        quartoMapper.updateEntityFromDto(dto, quarto);
        quartoRepository.save(quarto);

        return "Quarto atualizada com sucesso!";

    }

    @Transactional
    public String excluirQuarto(Long id) {

        quartoRepository.deleteById(id);

        return "Quarto excluida com sucesso!";

    }

    public List<QuartoDTO> listarQuartos() {
        return quartoRepository.findAll().stream().map(quartoMapper::toDto).toList();
    }

}