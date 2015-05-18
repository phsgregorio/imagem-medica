package com.puc.imagemmed.medico;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.puc.imagemmed.especialidade.Especialidade;
import com.puc.imagemmed.paciente.Paciente;
import com.puc.imagemmed.pessoa.Pessoa;

/**
 * Entidade Medico
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_medico")
public class Medico {

	@Id
	@GeneratedValue
	@Column(name = "id_medico", nullable = false)
	private Integer id_medico;
	
	@Column(name = "id_instituicao", nullable = false)
	private Integer id_instituicao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	@OrderBy("str_nome")
	private Pessoa pessoa;

	@OneToMany(targetEntity = Especialidade.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidade")
	private Collection<Especialidade> especialidade;
	
	@OneToMany(targetEntity = Paciente.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Collection<Paciente> pacientes;

	public Integer getId_medico() {
		return id_medico;
	}

	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}

	public Integer getId_instituicao() {
		return id_instituicao;
	}

	public void setId_instituicao(Integer id_instituicao) {
		this.id_instituicao = id_instituicao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Collection<Especialidade> getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Collection<Especialidade> especialidade) {
		this.especialidade = especialidade;
	}

	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
}