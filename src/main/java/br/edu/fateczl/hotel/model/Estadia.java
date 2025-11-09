package br.edu.fateczl.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_estadias")
@Entity
public class Estadia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_check_in", nullable = false)
    private LocalDateTime dataCheckIn;

    @Column(name = "data_check_out", nullable = false)
    private LocalDateTime dataCheckOut;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal; // Diarias + Servicos
    // calcularValorTotal, service? Pq pode ser calculado dinamicamente, nem precisa gravar no banco, só o valor final

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;

}