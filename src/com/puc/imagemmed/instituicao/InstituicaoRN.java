package com.puc.imagemmed.instituicao;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.commons.helpers.StringHelper;
import com.puc.commons.rn.GenericRN;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Instituicao
 * @author pedro.gregorio
 *
 */
public class InstituicaoRN extends GenericRN{

	private InstituicaoDAO dao;
	
	public InstituicaoRN() {
		this.dao = DAOFactory.getInstituicaoDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Instituicao
	 * @author pedro.gregorio
	 * @param instituicao
	 * @throws RNException
	 */
	public void save(Instituicao instituicao) throws RNException {

		try {
			if (instituicao.getId_instituicao() == null || instituicao.getId_instituicao() == 0) {
				this.dao.create(instituicao);
			} else {
				this.dao.update(instituicao);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar instituição.");
		}
	}
	
	@Override
	public Boolean validate(Object o) {
		Instituicao instituicao = (Instituicao) o;
		return 
				StringHelper.isNotEmpty(instituicao.getId_instituicao().toString()) && 
				StringHelper.isNotEmpty(instituicao.getStr_nome()) && 
				StringHelper.isNotEmpty(instituicao.getStr_email());
	}

	/**
	 * Método responsávle por recuperar uma Instituicao
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Instituicao retrieve(Integer codigo) throws RNException {
		try {
			return (Instituicao) this.dao.retrieve(Instituicao.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar instituição.");
		}
	}

	/**
	 * Método responsável por excluir uma Instituicao através de seu objeto
	 * @author pedro.gregorio
	 * @param isntituicao
	 * @throws RNException
	 */
	public void delete(Instituicao category) throws RNException {
		try {
			this.dao.delete(category);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir instituição.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Instituicao
	 * @author pedro.gregorio
	 * @param instituicao
	 * @throws RNException
	 */
	public void saveOrUpdate(Instituicao instituicao) throws RNException {
		try {
			this.dao.saveOrUpdate(instituicao);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar instituição.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de Instituicao
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Instituicao> getList() throws RNException {
		
		try {
			return this.dao.list(Instituicao.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar instituições.", e);
		}
	}
}
