package br.edu.fateczl.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "tb_hospedagens")
@Entity
public class Hospedagem {

    @Id
    private Long id;

    @Column(name = "data_checkin", nullable = false)
    private LocalDateTime dataCheckIn;

    @Column(name = "data_checkout", nullable = false)
    private LocalDateTime dataCheckOut;

    @Column(name = "valor_Total", nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private Quarto quarto;

    @Column(nullable = false)
    private Reserva reserva; //opcional;

    private List<ServicoSolicitado> serviços;

}