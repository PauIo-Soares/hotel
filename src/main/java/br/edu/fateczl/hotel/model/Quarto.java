package br.edu.fateczl.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_quartos")
@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(nullable = false)
    private Integer andar;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_quarto_id", nullable = false)
    private TipoQuarto tipoQuarto;

}