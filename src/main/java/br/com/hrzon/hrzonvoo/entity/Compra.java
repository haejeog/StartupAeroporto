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
@Table(name = "COMPRA")
@Data
public class Compra {

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "visitante_id")
	private Visitante visitante;

	private int quantidadePassagens;

	@ManyToOne
	@JoinColumn(name = "classe_id")
	private ClasseAviao classeEscolhida;

	private Date dataHoraCompra;

	private String estadoCompra;

}
