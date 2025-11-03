package br.edu.fateczl.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_servicos_solicitados")
@Entity
public class ServicoSolicitado {

    @Id
    private Long id;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;


    @Column(nullable = false)
    private Servico servico;

    @Column(nullable = false)
    private Hospedagem hospedagem;

}