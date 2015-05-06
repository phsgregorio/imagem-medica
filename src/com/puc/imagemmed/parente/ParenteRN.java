package com.puc.imagemmed.parente;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Parente
 * @author pedro.gregorio
 *
 */
public class ParenteRN {

	private ParenteDAO dao;
	
	public ParenteRN() {
		this.dao = DAOFactory.getParenteDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Parente
	 * @author pedro.gregorio
	 * @param parente
	 * @throws RNException
	 * TODO conferir id
	 */
	public void save(Parente parente) throws RNException {
		try {
			if (parente.getPessoa().getId_pessoa()!=null) {
				this.dao.create(parente);
			} else {
				this.dao.update(parente);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar parente.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Parente
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Parente retrieve(Integer codigo) throws RNException {
		try {
			return (Parente) this.dao.retrieve(Parente.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar parente.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Parente atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param parente
	 * @throws RNException
	 */
	public void delete(Parente category) throws RNException {
		try {
			this.dao.delete(category);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir parente.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Parente
	 * @author pedro.gregorio
	 * @param parente
	 * @throws RNException
	 */
	public void saveOrUpdate(Parente parente) throws RNException {
		try {
			this.dao.saveOrUpdate(parente);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar parente.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Parente
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Parente> getList() throws RNException {
		
		try {
			return this.dao.list(Parente.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar parentes.");
		}
	}
}
