package br.com.hrzon.hrzonvoo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GESTOR")
@Data
public class Gestor {

	@Id
	@Column(name = "gestor_id", unique = true, nullable = false)
	private UUID id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Column(name = "senha", nullable = false, length = 255)
	private String senha;

}
