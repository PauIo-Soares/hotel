package br.edu.fateczl.hotel.repository;

import br.edu.fateczl.hotel.model.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {}