package br.com.hrzon.hrzonvoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;

public interface ClasseAviaoRepository extends JpaRepository<ClasseAviao, Long> {

	List<ClasseAviao> findByVoo(Voo voo);
}
