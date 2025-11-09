package br.edu.fateczl.hotel.dto;

import br.edu.fateczl.hotel.model.Cliente;
import br.edu.fateczl.hotel.model.Quarto;

import java.time.LocalDate;

public record ReservaDTO(

        Long id,
        LocalDate dataReserva,
        LocalDate dataInicio,
        Integer quantidadeDias,
        Cliente cliente,
        Quarto quarto

) { }