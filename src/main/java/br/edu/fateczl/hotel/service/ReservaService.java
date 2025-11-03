package br.edu.fateczl.hotel.service;

import br.edu.fateczl.hotel.dto.ReservaDTO;
import br.edu.fateczl.hotel.mapper.ReservaMapper;
import br.edu.fateczl.hotel.model.Reserva;
import br.edu.fateczl.hotel.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Transactional
    public String criarReserva(ReservaDTO dto) {

        Reserva entidade = reservaMapper.toEntity(dto);
        reservaRepository.save(entidade);

        return "Reserva criada com sucesso!";

    }

    public ReservaDTO buscarReservaPorId(Long id) {

        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return reservaMapper.toDto(reserva);

    }

    @Transactional
    public String atualizarReserva(ReservaDTO dto) {

        Reserva reserva = reservaRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reservaMapper.updateEntityFromDto(dto, reserva);
        reservaRepository.save(reserva);

        return "Reserva atualizada com sucesso!";

    }

    @Transactional
    public String excluirReserva(Long id) {

        reservaRepository.deleteById(id);

        return "Reserva excluida com sucesso!";

    }

    public List<ReservaDTO> listarReservas() {
        return reservaRepository.findAll().stream().map(reservaMapper::toDto).toList();
    }

}