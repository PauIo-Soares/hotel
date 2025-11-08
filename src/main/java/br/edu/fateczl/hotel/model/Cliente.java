package br.edu.fateczl.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 17)
    private String telefone;

    @Column(name = "cidade_origem", nullable = false)
    private String cidadeOrigem;

}