package br.com.hrzon.hrzonvoo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CLASSE_AVIAO")
@Data
public class ClasseAviao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classeaviao_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "tipoClasse", nullable = false, length = 255)
	private String tipoClasse;

	@Column(name = "quantidadeAssentos", nullable = false)
	private int quantidadeAssentos;

	@Column(name = "valorAssento", nullable = false)
	private double valorAssento;

	@ManyToOne
	@JoinColumn(name = "voo_id")
	private Voo voo;
}
