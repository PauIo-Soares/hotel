package br.edu.fateczl.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_servicos_solicitados")
@Entity
public class ServicoSolicitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "estadia_id", nullable = false)
    private Estadia estadia;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

}