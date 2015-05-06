package com.puc.imagemmed.pessoa;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Pessoa
 * @author pedro.gregorio
 *
 */
public class PessoaRN {

	/**
	 * Pessoa DAO
	 */
	private PessoaDAO dao;
	
	public PessoaRN() {
		this.dao = DAOFactory.getPessoaDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto pessoa
	 * @author pedro.gregorio
	 * @param pessoa
	 * @throws RNException
	 */
	public void save(Pessoa pessoa) throws RNException {
		try {
			if (pessoa.getId_pessoa() == null || pessoa.getId_pessoa() == 0) {
				this.dao.create(pessoa);
			} else {
				this.dao.update(pessoa);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar pessoa.");
		}
	}

	/**
	 * Método responsávle por recuperar uma pessoa
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Pessoa retrieve(Integer codigo) throws RNException {
		try {
			return (Pessoa) this.dao.retrieve(Pessoa.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar pessoa.");
		}
	}

	/**
	 * Método responsável por excluir uma pessoa através de seu objeto
	 * @author pedro.gregorio
	 * @param pessoa
	 * @throws RNException
	 */
	public void delete(Pessoa pessoa) throws RNException {
		try {
			this.dao.delete(pessoa);
		} catch (DAOException e) {
			throw new RNException("Falha ao excluir pessoa.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma pessoa
	 * @author pedro.gregorio
	 * @param pessoa
	 * @throws RNException
	 */
	public void saveOrUpdate(Pessoa pessoa) throws RNException {
		try {
			this.dao.saveOrUpdate(pessoa);
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar pessoa.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de pessoas
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> getList() throws RNException {
		try {
			return this.dao.list(Pessoa.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar pessoas.");
		}
	}
}
