package br.edu.fateczl.hotel.dto;

import java.math.BigDecimal;

public record TipoQuartoDTO(

        Long id,
        String nome,
        BigDecimal valorDiaria

) { }