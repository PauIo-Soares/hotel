package br.edu.fateczl.hotel.dto;

import java.math.BigDecimal;

public record ServicoDTO(

        Long id,
        String nome,
        String descricao,
        BigDecimal valor

) { }