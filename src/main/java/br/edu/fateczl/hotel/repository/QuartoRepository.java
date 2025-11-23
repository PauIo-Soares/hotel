package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Optional<Quarto> findByNumero(Integer numero);

    void deleteByNumero(Integer numero);

}