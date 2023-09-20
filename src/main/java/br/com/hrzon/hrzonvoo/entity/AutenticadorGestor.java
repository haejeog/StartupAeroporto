package br.com.hrzon.hrzonvoo.entity;

import java.util.Date;

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
@Table(name = "AUTENTICADOR_GESTOR")
@Data
public class AutenticadorGestor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autenticador_id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "gestor_id")
	private Gestor gestor;

	private Date dataHoraAutenticacao;
}
