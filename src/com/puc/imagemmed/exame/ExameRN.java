package com.puc.imagemmed.exame;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Exame
 * @author pedro.gregorio
 *
 */
public class ExameRN {

	private ExameDAO dao;
	
	public ExameRN() {
		this.dao = DAOFactory.getExameDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Exame
	 * @author pedro.gregorio
	 * @param exame
	 * @throws RNException
	 */
	public void save(Exame exame) throws RNException {
		try {
			if (exame.getId_exame() == null || exame.getId_exame() == 0) {
				this.dao.create(exame);
			} else {
				this.dao.update(exame);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar exame.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Exame
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Exame retrieve(Integer codigo) throws RNException {
		try {
			return (Exame) this.dao.retrieve(Exame.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar exame.");
		}
	}

	/**
	 * Método responsável por excluir uma Exame através de seu objeto
	 * @author pedro.gregorio
	 * @param exame
	 * @throws RNException
	 */
	public void delete(Exame exame) throws RNException {
		try {
			this.dao.delete(exame);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir exame.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Exame
	 * @author pedro.gregorio
	 * @param exame
	 * @throws RNException
	 */
	public void saveOrUpdate(Exame exame) throws RNException {
		try {
			this.dao.saveOrUpdate(exame);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar exame.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de Exame
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Exame> getList() throws RNException {
		
		try {
			return this.dao.list(Exame.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar exames.");
		}
	}
}
