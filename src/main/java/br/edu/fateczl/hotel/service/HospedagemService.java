package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.HospedagemDTO;
import br.edu.fateczl.hotel.mapper.HospedagemMapper;
import br.edu.fateczl.hotel.model.Hospedagem;
import br.edu.fateczl.hotel.repository.HospedagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private HospedagemMapper hospedagemMapper;

    @Transactional
    public String criarHospedagem(HospedagemDTO dto) {

        Hospedagem entidade = hospedagemMapper.toEntity(dto);
        hospedagemRepository.save(entidade);

        return "Hospedagem criada com sucesso!";

    }

    public HospedagemDTO buscarHospedagemPorId(Long id) {

        Hospedagem hospedagem = hospedagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Hospedagem não encontrada"));

        return hospedagemMapper.toDto(hospedagem);

    }

    @Transactional
    public String atualizarHospedagem(HospedagemDTO dto) {

        Hospedagem hospedagem = hospedagemRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Hospedagem não encontrada"));
        hospedagemMapper.updateEntityFromDto(dto, hospedagem);
        hospedagemRepository.save(hospedagem);

        return "Hospedagem atualizada com sucesso!";

    }

    @Transactional
    public String excluirHospedagem(Long id) {

        hospedagemRepository.deleteById(id);

        return "Hospedagem excluida com sucesso!";

    }

    public List<HospedagemDTO> listarHospedagems() {
        return hospedagemRepository.findAll().stream().map(hospedagemMapper::toDto).toList();
    }

}