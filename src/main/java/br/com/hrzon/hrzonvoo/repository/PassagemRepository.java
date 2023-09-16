package br.com.hrzon.hrzonvoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
