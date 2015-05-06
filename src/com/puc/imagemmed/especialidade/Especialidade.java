package com.puc.imagemmed.especialidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Especialidade
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_especialidade")
public class Especialidade {

	@Id
	@GeneratedValue
	@Column(name = "id_especialidade", nullable = false)
	private Integer id_especialidade;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;

	public Integer getId_especialidade() {
		return id_especialidade;
	}

	public void setId_especialidade(Integer id_especialidade) {
		this.id_especialidade = id_especialidade;
	}

	public String getStr_nome() {
		return str_nome;
	}

	public void setStr_nome(String str_nome) {
		this.str_nome = str_nome;
	}

	public String getStr_descricao() {
		return str_descricao;
	}

	public void setStr_descricao(String str_descricao) {
		this.str_descricao = str_descricao;
	}
}