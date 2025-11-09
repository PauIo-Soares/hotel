package br.edu.fateczl.hotel.dto;

public record ClienteDTO(

        Long id,
        String cpf,
        String nome,
        String telefone,
        String cidadeOrigem

) { }