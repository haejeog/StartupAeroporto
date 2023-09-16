package br.com.hrzon.hrzonvoo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "VOUCHER")
@Data
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroPassagem;
	private String numeroVoo;
	private String origem;
	private String destino;
	private String passageiro;
	private boolean bagagemDespachada;

}
