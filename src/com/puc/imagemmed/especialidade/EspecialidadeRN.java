package com.puc.imagemmed.especialidade;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Especialidade
 * @author pedro.gregorio
 *
 */
public class EspecialidadeRN {

	private EspecialidadeDAO dao;
	
	public EspecialidadeRN() {
		this.dao = DAOFactory.getEspecialidadeDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Especialidade
	 * @author pedro.gregorio
	 * @param especialidade
	 * @throws RNException
	 */
	public void save(Especialidade especialidade) throws RNException {
		try {
			if (especialidade.getId_especialidade() == null || especialidade.getId_especialidade() == 0) {
				this.dao.create(especialidade);
			} else {
				this.dao.update(especialidade);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar doen�a.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Especialidade
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Especialidade retrieve(Integer codigo) throws RNException {
		try {
			return (Especialidade) this.dao.retrieve(Especialidade.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar doen�a.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Especialidade atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param especialidade
	 * @throws RNException
	 */
	public void delete(Especialidade especialidade) throws RNException {
		try {
			this.dao.delete(especialidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir doen�a.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Especialidade
	 * @author pedro.gregorio
	 * @param especialidade
	 * @throws RNException
	 */
	public void saveOrUpdate(Especialidade especialidade) throws RNException {
		try {
			this.dao.saveOrUpdate(especialidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar doen�a.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Especialidade
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Especialidade> getList() throws RNException {
		
		try {
			return this.dao.list(Especialidade.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar doen�as.");
		}
	}
}
