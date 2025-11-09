package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.ServicoSolicitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoSolicitadoRepository extends JpaRepository<ServicoSolicitado, Long> {}