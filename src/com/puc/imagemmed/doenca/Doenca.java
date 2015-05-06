package com.puc.imagemmed.doenca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Doenca
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_doenca")
public class Doenca {

	@Id
	@GeneratedValue
	@Column(name = "id_doenca", nullable = false)
	private Integer id_doenca;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;

	public Integer getId_doenca() {
		return id_doenca;
	}

	public void setId_doenca(Integer id_doenca) {
		this.id_doenca = id_doenca;
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
