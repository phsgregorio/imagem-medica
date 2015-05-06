package com.puc.imagemmed.exame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Exame
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_exame")
public class Exame {

	@Id
	@GeneratedValue
	@Column(name = "id_exame", nullable = false)
	private Integer id_exame;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;

	public Integer getId_exame() {
		return id_exame;
	}

	public void setId_exame(Integer id_exame) {
		this.id_exame = id_exame;
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
