package com.puc.imagemmed.usuario;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Usuario
 * @author pedro.gregorio
 *
 */
public class UsuarioRN {

	private UsuarioDAO dao;
	
	public UsuarioRN() {
		this.dao = DAOFactory.getUsuarioDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Usuario
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 * TODO adequar o método
	 */
	public void save(Usuario doenca) throws RNException {
		try {
			if (doenca.getPessoa().getId_pessoa()== null) {
				this.dao.create(doenca);
			} else {
				this.dao.update(doenca);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar usuário.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Usuario
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Usuario retrieve(Integer codigo) throws RNException {
		try {
			return (Usuario) this.dao.retrieve(Usuario.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar usuário.");
		}
	}

	/**
	 * Método responsável por excluir uma Usuario através de seu objeto
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void delete(Usuario usuario) throws RNException {
		try {
			this.dao.delete(usuario);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir usuário.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Usuario
	 * @author pedro.gregorio
	 * @param doenca
	 * @throws RNException
	 */
	public void saveOrUpdate(Usuario doenca) throws RNException {
		try {
			this.dao.saveOrUpdate(doenca);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar usuário.");
		}
	}

	/**
	 * Método responsável por retornar uma lista de Usuario
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
			throw new RNException("Falha ao listar usuários.");
		}
	}

	/**
	 * Método responsável por validar um usuário
	 * @param usuario
	 * @throws RNException 
	 */
	public Usuario validar(Usuario usuario) throws RNException {
		
		try {
			return this.dao.validate(Usuario.class, usuario);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao validar usuário.");
		}
	}
}
