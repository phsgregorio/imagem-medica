package com.puc.imagemmed.medico;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Medico
 * @author pedro.gregorio
 *
 */
public class MedicoRN {

	private MedicoDAO dao;
	
	public MedicoRN() {
		this.dao = DAOFactory.getMedicoDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Medico
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
			throw new RNException("Falha ao salvar médico.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Medico
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Medico retrieve(Integer codigo) throws RNException {
		try {
			return (Medico) this.dao.retrieve(Medico.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar médico.");
		}
	}

	/**
	 * Método responsável por excluir uma Medico através de seu objeto
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void delete(Medico medico) throws RNException {
		try {
			this.dao.delete(medico);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir médico.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Medico
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void saveOrUpdate(Medico doenca) throws RNException {
		try {
			this.dao.saveOrUpdate(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar médico.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de Medico
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Medico> getList() throws RNException {
		
		try {
			return this.dao.list(Medico.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar médicos.");
		}
	}
}
