package br.com.hrzon.hrzonvoo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hrzon.hrzonvoo.entity.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, UUID> {

	List<Passagem> findByCpfPassageiro(String cpfPassageiro);

	@Query("SELECT * FROM PASSAGEM WHERE voo_id = ?")
	List<Passagem> findByVoo(UUID vooId);

}
