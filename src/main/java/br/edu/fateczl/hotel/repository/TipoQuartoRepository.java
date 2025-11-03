package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long> {}