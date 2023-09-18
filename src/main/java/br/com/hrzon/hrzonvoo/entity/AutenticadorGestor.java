package br.com.hrzon.hrzonvoo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
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
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "gestor_id")
	private Gestor gestor;

	private Date dataHoraAutenticacao;
}
