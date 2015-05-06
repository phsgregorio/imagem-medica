package com.puc.imagemmed.nota;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Nota
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_nota")
public class Nota {

	@Id
	@GeneratedValue
	@Column(name = "id_nota", nullable = false)
	private Integer id_nota;
	
	@Column(name = "id_paciente", nullable = false)
	private Integer id_paciente;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;
	
	@Column(name = "dta_nota", nullable = true)
	private Date dta_nota;

	public Integer getId_nota() {
		return id_nota;
	}

	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getStr_descricao() {
		return str_descricao;
	}

	public void setStr_descricao(String str_descricao) {
		this.str_descricao = str_descricao;
	}

	public Date getDta_nota() {
		return dta_nota;
	}

	public void setDta_nota(Date dta_nota) {
		this.dta_nota = dta_nota;
	}
}
