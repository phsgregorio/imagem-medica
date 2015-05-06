package com.puc.imagemmed.parente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.puc.imagemmed.pessoa.Pessoa;

/**
 * Entidade Parente
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_parente")
public class Parente {

	@Id
	@GeneratedValue
	@Column(name = "id_parente", nullable = false)
	private Integer id_parente;

	@Column(name = "id_paciente", nullable = false)
	private Integer id_paciente;
	
	@Column(name = "str_parentesco", nullable = false)
	private String str_parentesco;

	@Column(name = "str_observacoes", nullable = false)
	private String str_observacoes;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	@OrderBy("str_nome")
	private Pessoa pessoa;

	public Integer getId_parente() {
		return id_parente;
	}

	public void setId_parente(Integer id_parente) {
		this.id_parente = id_parente;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getStr_parentesco() {
		return str_parentesco;
	}

	public void setStr_parentesco(String str_parentesco) {
		this.str_parentesco = str_parentesco;
	}

	public String getStr_observacoes() {
		return str_observacoes;
	}

	public void setStr_observacoes(String str_observacoes) {
		this.str_observacoes = str_observacoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
