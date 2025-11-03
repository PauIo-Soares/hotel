package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {}