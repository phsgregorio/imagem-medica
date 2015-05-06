package com.puc.imagemmed.especialidade;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Especialidade
 * @author pedro.gregorio
 *
 */
public class EspecialidadeRN {

	private EspecialidadeDAO dao;
	
	public EspecialidadeRN() {
		this.dao = DAOFactory.getEspecialidadeDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Especialidade
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
			throw new RNException("Falha ao salvar doença.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Especialidade
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Especialidade retrieve(Integer codigo) throws RNException {
		try {
			return (Especialidade) this.dao.retrieve(Especialidade.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar doença.");
		}
	}

	/**
	 * Método responsável por excluir uma Especialidade através de seu objeto
	 * @author pedro.gregorio
	 * @param especialidade
	 * @throws RNException
	 */
	public void delete(Especialidade especialidade) throws RNException {
		try {
			this.dao.delete(especialidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir doença.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Especialidade
	 * @author pedro.gregorio
	 * @param especialidade
	 * @throws RNException
	 */
	public void saveOrUpdate(Especialidade especialidade) throws RNException {
		try {
			this.dao.saveOrUpdate(especialidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar doença.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de Especialidade
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Especialidade> getList() throws RNException {
		
		try {
			return this.dao.list(Especialidade.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar doenças.");
		}
	}
}
