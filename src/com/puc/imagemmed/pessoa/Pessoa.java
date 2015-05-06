package com.puc.imagemmed.pessoa;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imed_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "id_pessoa", nullable = false)
	private Integer id_pessoa;
	
	@Column(name = "str_nome", nullable = false, length = 45)
	private String str_nome;
	
	@Column(name = "dta_nascimento", nullable = false, length = 45)
	private Date dta_nascimento;
	
	@Column(name = "chr_sexo")
	private Character chr_sexo;
	
	@Column(name = "num_telefone")
	private Integer num_telefone;
	
	@Column(name = "num_fax")
	private Integer num_fax;

	@Column(name = "str_email")
	private String str_email;

	@Column(name = "num_cep")
	private Integer num_cep;
	
	@Column(name = "str_uf", nullable = false, length = 45)
	private String str_uf;
	
	@Column(name = "str_cidade", nullable = false, length = 45)
	private String str_cidade;

	@Column(name = "str_endereco")
	private String str_endereco;
	
	@Column(name = "num_endereco")
	private Integer num_endereco;
	
	@Column(name = "str_bairro")
	private String str_bairro;
	
	@Column(name = "num_rg")
	private Integer num_rg;
	
	@Column(name = "str_cpf")
	private String str_cpf;

	public Pessoa() {
	}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getStr_nome() {
		return str_nome;
	}

	public void setStr_nome(String str_nome) {
		this.str_nome = str_nome;
	}

	public Date getDta_nascimento() {
		return dta_nascimento;
	}

	public void setDta_nascimento(Date dta_nascimento) {
		this.dta_nascimento = dta_nascimento;
	}

	public Character getChr_sexo() {
		return chr_sexo;
	}

	public void setChr_sexo(Character chr_sexo) {
		this.chr_sexo = chr_sexo;
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

	public Integer getNum_cep() {
		return num_cep;
	}

	public void setNum_cep(Integer num_cep) {
		this.num_cep = num_cep;
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

	public Integer getNum_endereco() {
		return num_endereco;
	}

	public void setNum_endereco(Integer num_endereco) {
		this.num_endereco = num_endereco;
	}

	public String getStr_bairro() {
		return str_bairro;
	}

	public void setStr_bairro(String str_bairro) {
		this.str_bairro = str_bairro;
	}

	public Integer getNum_rg() {
		return num_rg;
	}

	public void setNum_rg(Integer num_rg) {
		this.num_rg = num_rg;
	}

	public String getStr_cpf() {
		return str_cpf;
	}

	public void setStr_cpf(String str_cpf) {
		this.str_cpf = str_cpf;
	}
}
