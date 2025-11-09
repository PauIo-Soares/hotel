package br.edu.fateczl.hotel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EstadiaDTO(

        Long id,
        LocalDateTime dataCheckIn,
        LocalDateTime dataCheckOut,
        BigDecimal valorTotal,
        Long clienteId,
        Long quartoId

) { }