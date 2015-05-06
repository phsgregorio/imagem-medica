package com.puc.commons.helpers;

/**
 * Classe usada para retornar um erro por json/xml
 * @author pedro.gregorio
 *
 */
public class Error {

	private Integer codigo;
	private String mensagem;

	public Error(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
