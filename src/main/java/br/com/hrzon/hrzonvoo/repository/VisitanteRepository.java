package br.com.hrzon.hrzonvoo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, UUID> {

}
