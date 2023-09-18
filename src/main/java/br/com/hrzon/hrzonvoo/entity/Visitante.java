package br.com.hrzon.hrzonvoo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "VISITANTE")
@Data
public class Visitante {

	@Id
	private UUID id;

	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String email;

}
