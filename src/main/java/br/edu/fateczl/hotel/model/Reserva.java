package br.edu.fateczl.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_reservas")
@Entity
public class Reserva {

    @Id
    private Long id;

    @Column(name = "data_reserva", nullable = false)
    private LocalDateTime dataReserva;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "quantidade_dias", nullable = false)
    private Integer quantidadeDias;

    private Enum status;

    @Column(nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private Quarto quarto;

}