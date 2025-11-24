package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Optional<Quarto> findByNumero(Integer numero);

    void deleteByNumero(Integer numero);

    @Query(value = "SELECT * FROM fn_listaQuartos(:data)", nativeQuery = true)
    List<Quarto> listarQuartosDisponiveis(@Param("data") LocalDate data);

}