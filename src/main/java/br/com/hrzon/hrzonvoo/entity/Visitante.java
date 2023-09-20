package br.com.hrzon.hrzonvoo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "VISITANTE")
@Data
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitante_id", unique = true, nullable = false)
	private Long id;

	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String email;

}
