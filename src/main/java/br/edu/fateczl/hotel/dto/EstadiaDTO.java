package br.edu.fateczl.hotel.dto;

import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.model.Quarto;
import br.edu.fateczl.hotel.model.ServicoSolicitado;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record EstadiaDTO(

        Long id,
        LocalDateTime dataCheckIn,
        LocalDateTime dataCheckOut,
        BigDecimal valorTotal,
        Cliente cliente,
        Quarto quarto,
        List<ServicoSolicitado> servicosSolicitados

) {
}