package com.puc.imagemmed.permissao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Permissão
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_permissao")
public class Permissao {

	@Id
	@GeneratedValue
	@Column(name = "id_permissao", nullable = false)
	private Integer id_permissao;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;

	public Integer getId_permissao() {
		return id_permissao;
	}

	public void setId_permissao(Integer id_permissao) {
		this.id_permissao = id_permissao;
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
