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
@Table(name = "PASSAGEM")
@Data
public class Passagem {

	@Id
	private UUID id;

	private String numeroIdentificacaoUnico;
	private String nomePassageiro;
	private String cpfPassageiro;
	private Date dataNascimentoPassageiro;
	private Double precoTotalPassagem;
	private boolean bagagemDespachada;

	@ManyToOne
	@JoinColumn(name = "classe_id")
	private ClasseAviao classe;

	@ManyToOne
	@JoinColumn(name = "voo_id")
	private Voo voo;

	@ManyToOne
	@JoinColumn(name = "comprador_id")
	private Visitante comprador;

}
