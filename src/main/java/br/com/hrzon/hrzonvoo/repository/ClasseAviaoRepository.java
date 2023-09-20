package br.com.hrzon.hrzonvoo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;

public interface ClasseAviaoRepository extends JpaRepository<ClasseAviao, UUID> {

	List<ClasseAviao> findByVoo(Voo voo);
}
