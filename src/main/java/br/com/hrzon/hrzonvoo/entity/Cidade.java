package br.com.hrzon.hrzonvoo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CIDADE")
@Data
public class Cidade {

	@Id
	@Column(name = "cidade_id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "unidadeFederativa", nullable = false, length = 255)
	private String unidadeFederativa;

	

}
