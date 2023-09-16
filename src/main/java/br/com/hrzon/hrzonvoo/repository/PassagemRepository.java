package br.com.hrzon.hrzonvoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

	List<Passagem> findByCpfPassageiro(String cpfPassageiro);


}
