package br.com.hrzon.hrzonvoo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Gestor;

public interface GestorRepository extends JpaRepository<Gestor, UUID> {
}
