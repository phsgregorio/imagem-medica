package com.puc.imagemmed.instituicao;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.puc.imagemmed.medico.Medico;

/**
 * 
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_instituicao")
public class Instituicao {

	@Id
	@GeneratedValue
	@Column(name = "id_instituicao", nullable = false)
	private Integer id_instituicao;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;
	
	@Column(name = "num_telefone", nullable = true)
	private Integer num_telefone;
	
	@Column(name = "num_fax", nullable = true)
	private Integer num_fax;
	
	@Column(name = "str_email", nullable = false, length = 45)
	private String str_email;
	
	@Column(name = "str_uf", nullable = true, length = 45)
	private String str_uf;
	
	@Column(name = "str_cidade", nullable = true, length = 45)
	private String str_cidade;
	
	@Column(name = "str_endereco", nullable = true, length = 150)
	private String str_endereco;

	@Column(name = "str_bairro", nullable = true, length = 45)
	private String str_bairro;

	@Column(name = "num_endereco", nullable = true)
	private Integer num_endereco;
	
	// TODO Testar
	@OneToMany(targetEntity = Medico.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
	private Collection<Medico> medicos;

	public Integer getId_instituicao() {
		return id_instituicao;
	}

	public void setId_instituicao(Integer id_instituicao) {
		this.id_instituicao = id_instituicao;
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

	public Integer getNum_telefone() {
		return num_telefone;
	}

	public void setNum_telefone(Integer num_telefone) {
		this.num_telefone = num_telefone;
	}

	public Integer getNum_fax() {
		return num_fax;
	}

	public void setNum_fax(Integer num_fax) {
		this.num_fax = num_fax;
	}

	public String getStr_email() {
		return str_email;
	}

	public void setStr_email(String str_email) {
		this.str_email = str_email;
	}

	public String getStr_uf() {
		return str_uf;
	}

	public void setStr_uf(String str_uf) {
		this.str_uf = str_uf;
	}

	public String getStr_cidade() {
		return str_cidade;
	}

	public void setStr_cidade(String str_cidade) {
		this.str_cidade = str_cidade;
	}

	public String getStr_endereco() {
		return str_endereco;
	}

	public void setStr_endereco(String str_endereco) {
		this.str_endereco = str_endereco;
	}

	public String getStr_bairro() {
		return str_bairro;
	}

	public void setStr_bairro(String str_bairro) {
		this.str_bairro = str_bairro;
	}

	public Integer getNum_endereco() {
		return num_endereco;
	}

	public void setNum_endereco(Integer num_endereco) {
		this.num_endereco = num_endereco;
	}

	public Collection<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Collection<Medico> medicos) {
		this.medicos = medicos;
	}
}