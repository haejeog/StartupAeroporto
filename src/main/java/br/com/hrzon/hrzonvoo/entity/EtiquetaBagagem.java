package br.com.hrzon.hrzonvoo.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ETIQUETA_BAGAGEM")
@Data
public class EtiquetaBagagem {

	@Id
	private UUID id;

	private String numeroPassagem;

	private String numeroBagagem;

	private String nomePassageiro;

}
