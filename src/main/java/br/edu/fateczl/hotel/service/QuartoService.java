package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.dto.QuartoDisponivelDTO;
import br.edu.fateczl.hotel.mapper.QuartoMapper;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

        return "Quarto criado com sucesso!";

    }

    public QuartoDTO buscarQuartoPorNumero(Integer numero) {

        Quarto quarto = quartoRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        return quartoMapper.toDto(quarto);

    }

    @Transactional
    public String atualizarQuarto(QuartoDTO dto) {

        Quarto quarto = quartoRepository.findByNumero(dto.numero()).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        quartoMapper.updateEntityFromDto(dto, quarto);
        quartoRepository.save(quarto);

        return "Quarto atualizado com sucesso!";

    }

    @Transactional
    public String excluirQuartoPorNumero(Integer numero) {

        quartoRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        quartoRepository.deleteByNumero(numero);

        return "Quarto excluido com sucesso!";

    }

    public List<QuartoDTO> listarQuartos() {
        return quartoRepository.findAll().stream().map(quartoMapper::toDto).toList();
    }

    public List<QuartoDisponivelDTO> listarQuartosDisponiveis(LocalDate data) {

        List<Quarto> quartos = quartoRepository.listarQuartosDisponiveis(data);

        List<QuartoDisponivelDTO> dtos = new ArrayList<>();

        for (Quarto q : quartos) {

            QuartoDisponivelDTO dto = new QuartoDisponivelDTO(
                    q.getNumero(),
                    q.getAndar(),
                    q.getDescricao()
            );

            dtos.add(dto);
        }

        return dtos;
    }

}