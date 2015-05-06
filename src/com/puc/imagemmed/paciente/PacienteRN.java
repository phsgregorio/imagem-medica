package com.puc.imagemmed.paciente;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Paciente
 * @author pedro.gregorio
 *
 */
public class PacienteRN {

	private PacienteDAO dao;
	
	public PacienteRN() {
		this.dao = DAOFactory.getPacienteDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Paciente
	 * @author pedro.gregorio
	 * @param paciente
	 * @throws RNException
	 */
	public void save(Paciente paciente) throws RNException {
		try {
			if (paciente.getId_paciente() == null || paciente.getId_paciente() == 0) {
				this.dao.create(paciente);
			} else {
				this.dao.update(paciente);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar paciente.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Paciente
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Paciente retrieve(Integer codigo) throws RNException {
		try {
			return (Paciente) this.dao.retrieve(Paciente.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar paciente.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Paciente atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param paciente
	 * @throws RNException
	 */
	public void delete(Paciente paciente) throws RNException {
		try {
			this.dao.delete(paciente);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir paciente.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Paciente
	 * @author pedro.gregorio
	 * @param paciente
	 * @throws RNException
	 */
	public void saveOrUpdate(Paciente paciente) throws RNException {
		try {
			this.dao.saveOrUpdate(paciente);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar paciente.");
		}
	}

	/**
	 * M�todo respons�vle por retornar uma lista de Paciente
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Paciente> getList() throws RNException {
		
		try {
			return this.dao.list(Paciente.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar pacientes.");
		}
	}
}
