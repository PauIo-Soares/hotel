package br.edu.fateczl.hotel.dto;

public record QuartoDTO(

        Long id,
        Integer numero,
        Integer andar,
        String descricao,
        Long tipoQuartoId

) { }