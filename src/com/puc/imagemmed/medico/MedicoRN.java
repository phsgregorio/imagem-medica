package com.puc.imagemmed.medico;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Medico
 * @author pedro.gregorio
 *
 */
public class MedicoRN {

	private MedicoDAO dao;
	
	public MedicoRN() {
		this.dao = DAOFactory.getMedicoDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Medico
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void save(Medico doenca) throws RNException {
		try {
			if (doenca.getId_medico() == null || doenca.getId_medico() == 0) {
				this.dao.create(doenca);
			} else {
				this.dao.update(doenca);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar m�dico.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Medico
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Medico retrieve(Integer codigo) throws RNException {
		try {
			return (Medico) this.dao.retrieve(Medico.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar m�dico.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Medico atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void delete(Medico medico) throws RNException {
		try {
			this.dao.delete(medico);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir m�dico.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Medico
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void saveOrUpdate(Medico doenca) throws RNException {
		try {
			this.dao.saveOrUpdate(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar m�dico.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Medico
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Medico> getList() throws RNException {
		
		try {
			return this.dao.list(Medico.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar m�dicos.");
		}
	}
}
