package br.edu.fateczl.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_quartos")
@Entity
public class Quarto {

    @Id
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer andar;

    @Column(nullable = false)
    private String descricao;

}