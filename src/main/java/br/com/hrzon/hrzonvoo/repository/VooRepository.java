package br.com.hrzon.hrzonvoo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Voo;

public interface VooRepository extends JpaRepository<Voo, UUID> {

}
