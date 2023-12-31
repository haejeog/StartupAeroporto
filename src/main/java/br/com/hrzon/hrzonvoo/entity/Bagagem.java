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
@Table(name = "BAGAGEM")
@Data
public class Bagagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bagagem_id", unique = true, nullable = false)
	private Long id;

	private String numeroIdentificacaoUnico;

	@ManyToOne
	@JoinColumn(name = "passagem_id")
	private Passagem passagem;

}
