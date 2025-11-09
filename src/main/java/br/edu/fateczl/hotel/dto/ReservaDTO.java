package br.edu.fateczl.hotel.dto;

import br.edu.fateczl.hotel.enums.StatusReserva;

import java.time.LocalDate;

public record ReservaDTO(

        Long id,
        LocalDate dataReserva,
        LocalDate dataInicio,
        Integer quantidadeDias,
        Long clienteId,
        Long quartoId,
        StatusReserva status

) { }