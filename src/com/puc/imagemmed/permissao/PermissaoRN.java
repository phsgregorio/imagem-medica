package com.puc.imagemmed.permissao;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Permissao
 * @author pedro.gregorio
 *
 */
public class PermissaoRN {

	private PermissaoDAO dao;
	
	public PermissaoRN() {
		this.dao = DAOFactory.getPermissaoDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Permissao
	 * @author pedro.gregorio
	 * @param permissao
	 * @throws RNException
	 */
	public void save(Permissao permissao) throws RNException {
		try {
			if (permissao.getId_permissao() == null || permissao.getId_permissao() == 0) {
				this.dao.create(permissao);
			} else {
				this.dao.update(permissao);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar permissão.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Permissao
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Permissao retrieve(Integer codigo) throws RNException {
		try {
			return (Permissao) this.dao.retrieve(Permissao.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar permissão.");
		}
	}

	/**
	 * Método responsável por excluir uma Permissao através de seu objeto
	 * @author pedro.gregorio
	 * @param permissao
	 * @throws RNException
	 */
	public void delete(Permissao permissao) throws RNException {
		try {
			this.dao.delete(permissao);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir permissão.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Permissao
	 * @author pedro.gregorio
	 * @param permissao
	 * @throws RNException
	 */
	public void saveOrUpdate(Permissao permissao) throws RNException {
		try {
			this.dao.saveOrUpdate(permissao);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar permissão.");
		}
	}

	/**
	 * Método responsável por retornar uma lista de Permissao
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Permissao> getList() throws RNException {
		
		try {
			return this.dao.list(Permissao.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar permissões.");
		}
	}
}
