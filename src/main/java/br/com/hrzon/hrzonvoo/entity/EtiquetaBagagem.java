package br.com.hrzon.hrzonvoo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ETIQUETA_BAGAGEM")
@Data
public class EtiquetaBagagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etiqueta_id", unique = true, nullable = false)
	private Long id;

	private String numeroPassagem;

	private String numeroBagagem;

	private String nomePassageiro;

}
