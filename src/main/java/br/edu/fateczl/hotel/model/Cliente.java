package br.edu.fateczl.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_clientes")
@Entity
public class Cliente {

    @Id
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cidade;

}