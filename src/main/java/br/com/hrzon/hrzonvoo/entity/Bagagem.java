package br.com.hrzon.hrzonvoo.entity;

import java.util.UUID;

import javax.persistence.Entity;
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
	private UUID id;

	private String numeroIdentificacaoUnico;

	@ManyToOne
	@JoinColumn(name = "passagem_id")
	private Passagem passagem;

}
