package br.com.hrzon.hrzonvoo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, UUID> {

	Aeroporto findByCodigoIATA(String codigoIATA);

}
