package br.com.hrzon.hrzonvoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hrzon.hrzonvoo.entity.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

	List<Passagem> findByCpfPassageiro(String cpfPassageiro);

	@Query(value = "SELECT * FROM PASSAGEM WHERE voo_id = %?1%", nativeQuery = true)
	List<Passagem> findByVoo(Long voo);

}
