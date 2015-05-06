package com.puc.imagemmed.usuario;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe respons�vel por gerenciar as regras de neg�cio relacionadas a Usuario
 * @author pedro.gregorio
 *
 */
public class UsuarioRN {

	private UsuarioDAO dao;
	
	public UsuarioRN() {
		this.dao = DAOFactory.getUsuarioDAO();
	}

	/**
	 * M�todo respons�vel por salvar/atualizar um objeto Usuario
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 * TODO adequar o m�todo
	 */
	public void save(Usuario doenca) throws RNException {
		try {
			if (doenca.getPessoa().getId_pessoa()== null) {
				this.dao.create(doenca);
			} else {
				this.dao.update(doenca);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar usu�rio.");
		}
	}

	/**
	 * M�todo respons�vle por recuperar uma Usuario
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Usuario retrieve(Integer codigo) throws RNException {
		try {
			return (Usuario) this.dao.retrieve(Usuario.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar usu�rio.");
		}
	}

	/**
	 * M�todo respons�vel por excluir uma Usuario atrav�s de seu objeto
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void delete(Usuario usuario) throws RNException {
		try {
			this.dao.delete(usuario);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir usu�rio.");
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar uma Usuario
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void saveOrUpdate(Usuario doenca) throws RNException {
		try {
			this.dao.saveOrUpdate(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar usu�rio.");
		}
	}

	/**
	 * M�todo respons�vel por retornar uma lista de Usuario
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> getList() throws RNException {
		
		try {
			return this.dao.list(Usuario.class, "id_usuario");
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao listar usu�rios.");
		}
	}

	/**
	 * M�todo respons�vel por validar um usu�rio
	 * @param usuario
	 * @throws RNException 
	 */
	public Usuario validar(Usuario usuario) throws RNException {
		
		try {
			return this.dao.validate(Usuario.class, usuario);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao validar usu�rio.");
		}
	}
}
