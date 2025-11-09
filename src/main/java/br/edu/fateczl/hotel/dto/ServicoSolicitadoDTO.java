package br.edu.fateczl.hotel.dto;

import java.math.BigDecimal;

public record ServicoSolicitadoDTO(

        Long id,
        Integer quantidade,
        BigDecimal valorTotal,
        Long estadiaId,
        Long servicoId

) { }