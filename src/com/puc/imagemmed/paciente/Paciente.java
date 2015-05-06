package com.puc.imagemmed.paciente;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.puc.imagemmed.diagnostico.Diagnostico;
import com.puc.imagemmed.exame.Exame;
import com.puc.imagemmed.nota.Nota;
import com.puc.imagemmed.pessoa.Pessoa;


/**
 * Entidade Paciente
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_medico")
public class Paciente {

	public Paciente() {
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id_paciente", nullable = false)
	private Integer id_paciente;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	@OrderBy("str_nome")
	private Pessoa pessoa;

	// TODO persistir agregações e composições
	private ArrayList<Pessoa> parentes;
	private ArrayList<Exame> exames;
	private ArrayList<Diagnostico> diagnosticos;
	private ArrayList<Nota> notas;

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ArrayList<Pessoa> getParentes() {
		return parentes;
	}

	public void setParentes(ArrayList<Pessoa> parentes) {
		this.parentes = parentes;
	}

	public ArrayList<Exame> getExames() {
		return exames;
	}

	public void setExames(ArrayList<Exame> exames) {
		this.exames = exames;
	}

	public ArrayList<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
}