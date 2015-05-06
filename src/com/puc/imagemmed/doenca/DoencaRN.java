package com.puc.imagemmed.doenca;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Doenca
 * @author pedro.gregorio
 *
 */
public class DoencaRN {

	private DoencaDAO dao;
	
	public DoencaRN() {
		this.dao = DAOFactory.getDoencaDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Doenca
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void save(Doenca doenca) throws RNException {
		try {
			if (doenca.getId_doenca() == null || doenca.getId_doenca() == 0) {
				this.dao.create(doenca);
			} else {
				this.dao.update(doenca);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar doen�a.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Doenca
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Doenca retrieve(Integer codigo) throws RNException {
		try {
			return (Doenca) this.dao.retrieve(Doenca.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar doen�a.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Doenca atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void delete(Doenca doenca) throws RNException {
		try {
			this.dao.delete(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir doen�a.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Doenca
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void saveOrUpdate(Doenca doenca) throws RNException {
		try {
			this.dao.saveOrUpdate(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar doen�a.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Doenca
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Doenca> getList() throws RNException {
		
		try {
			return this.dao.list(Doenca.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar doen�as.");
		}
	}
}
