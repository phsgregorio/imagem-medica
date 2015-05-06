package com.puc.imagemmed.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.puc.imagemmed.permissao.Permissao;
import com.puc.imagemmed.pessoa.Pessoa;

/**
 * Classe de entidade Usuario
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario", nullable = false)
	private Integer id_usuario;
	
	@Column(name = "str_senha", nullable = false)
	private String str_senha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permissao")
	private Permissao permissao;

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getStr_senha() {
		return str_senha;
	}

	public void setStr_senha(String str_senha) {
		this.str_senha = str_senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
}
