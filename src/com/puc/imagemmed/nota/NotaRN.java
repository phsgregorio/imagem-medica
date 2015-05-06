package com.puc.imagemmed.nota;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Nota
 * @author pedro.gregorio
 *
 */
public class NotaRN {

	private NotaDAO dao;
	
	public NotaRN() {
		this.dao = DAOFactory.getNotaDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Nota
	 * @author pedro.gregorio
	 * @param nota
	 * @throws RNException
	 */
	public void save(Nota nota) throws RNException {
		try {
			if (nota.getId_nota() == null || nota.getId_nota() == 0) {
				this.dao.create(nota);
			} else {
				this.dao.update(nota);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar nota.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Nota
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Nota retrieve(Integer codigo) throws RNException {
		try {
			return (Nota) this.dao.retrieve(Nota.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar nota.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Nota atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param nota
	 * @throws RNException
	 */
	public void delete(Nota nota) throws RNException {
		try {
			this.dao.delete(nota);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir nota.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Nota
	 * @author pedro.gregorio
	 * @param nota
	 * @throws RNException
	 */
	public void saveOrUpdate(Nota nota) throws RNException {
		try {
			this.dao.saveOrUpdate(nota);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar nota.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Nota
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Nota> getList() throws RNException {
		
		try {
			return this.dao.list(Nota.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar notas.");
		}
	}
}
