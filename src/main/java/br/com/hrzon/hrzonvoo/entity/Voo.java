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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "VOO")
@Data
public class Voo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voo_id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aeroporto_origem_codigo")
	private Aeroporto aeroportoOrigem;

	@ManyToOne
	@JoinColumn(name = "aeroporto_destino_codigo")
	private Aeroporto aeroportoDestino;

	@Column(unique = true)
	private String numeracaoUnica;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraPartida;

	private int capacidadeMaximaPassageiros;

}
