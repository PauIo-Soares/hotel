package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.TipoQuartoDTO;
import br.edu.fateczl.hotel.mapper.TipoQuartoMapper;
import br.edu.fateczl.hotel.model.TipoQuarto;
import br.edu.fateczl.hotel.repository.TipoQuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoQuartoService {

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    @Autowired
    private TipoQuartoMapper tipoQuartoMapper;

    @Transactional
    public String criarTipoQuarto(TipoQuartoDTO dto) {

        TipoQuarto entidade = tipoQuartoMapper.toEntity(dto);
        tipoQuartoRepository.save(entidade);

        return "Tipo de Quarto criado com sucesso!";

    }

    public TipoQuartoDTO buscarTipoQuartoPorId(Long id) {

        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Quarto não encontrado"));

        return tipoQuartoMapper.toDto(tipoQuarto);

    }

    @Transactional
    public String atualizarTipoQuarto(TipoQuartoDTO dto) {

        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Tipo de Quarto não encontrado"));

        tipoQuartoMapper.updateEntityFromDto(dto, tipoQuarto);
        tipoQuartoRepository.save(tipoQuarto);

        return "Tipo de Quarto atualizado com sucesso!";

    }

    @Transactional
    public String excluirTipoQuarto(Long id) {

        tipoQuartoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Quarto não encontrado"));


        tipoQuartoRepository.deleteById(id);

        return "Tipo de Quarto excluido com sucesso!";

    }

    public List<TipoQuartoDTO> listarTiposQuarto() {
        return tipoQuartoRepository.findAll().stream().map(tipoQuartoMapper::toDto).toList();
    }

}