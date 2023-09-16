package br.com.hrzon.hrzonvoo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AEROPORTO")
@Data
public class Aeroporto {

	@Id
	private String codigoIATA;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
}
