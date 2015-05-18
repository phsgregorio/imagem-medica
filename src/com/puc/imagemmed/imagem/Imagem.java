package com.puc.imagemmed.imagem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Entidade Imagem
 * @author pedro.gregorio
 *
 */
@Entity
@Table(name = "imed_paciente_imagem")
public class Imagem {

	@Id
	@GeneratedValue
	@Column(name = "id_imagem", nullable = false)
	private Integer id_imagem;
	
	@Column(name = "id_paciente", nullable = false)
	private Integer id_paciente;
	
	@Column(name = "str_caminho_fisico", nullable = false, length = 255)
	private String str_caminho_fisico;
	
	@Column(name = "str_descricao", nullable = true, length = 255)
	private String str_descricao;
	
//	TODO pedro.gregorio Criar CRUD tipoImagem
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_pessoa")
//	@OrderBy("str_nome")
//	private TipoImagem tipoImagem;

	public Integer getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(Integer id_imagem) {
		this.id_imagem = id_imagem;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getStr_caminho_fisico() {
		return str_caminho_fisico;
	}

	public void setStr_caminho_fisico(String str_caminho_fisico) {
		this.str_caminho_fisico = str_caminho_fisico;
	}

	public String getStr_descricao() {
		return str_descricao;
	}

	public void setStr_descricao(String str_descricao) {
		this.str_descricao = str_descricao;
	}
}