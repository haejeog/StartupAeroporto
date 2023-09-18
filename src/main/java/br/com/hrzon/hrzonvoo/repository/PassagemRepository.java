package br.com.hrzon.hrzonvoo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.entity.Voo;

public interface PassagemRepository extends JpaRepository<Passagem, UUID> {

	List<Passagem> findByCpfPassageiro(String cpfPassageiro);

	List<Passagem> findByVoo(Voo voo);

}
