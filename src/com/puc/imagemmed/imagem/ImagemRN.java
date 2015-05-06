package com.puc.imagemmed.imagem;

import java.util.List;

import com.puc.commons.exceptions.DAOException;
import com.puc.commons.exceptions.RNException;
import com.puc.hibernate.dao.DAOFactory;


/**
 * Classe responsável por gerenciar as regras de negócio relacionadas a Imagem
 * @author pedro.gregorio
 *
 */
public class ImagemRN {

	private ImagemDAO dao;
	
	public ImagemRN() {
		this.dao = DAOFactory.getImagemDAO();
	}

	/**
	 * Método responsável por salvar/atualizar um objeto Imagem
	 * @author pedro.gregorio
	 * @param imagem
	 * @throws RNException
	 */
	public void save(Imagem imagem) throws RNException {
		try {
			if (imagem.getId_imagem() == null || imagem.getId_imagem() == 0) {
				this.dao.create(imagem);
			} else {
				this.dao.update(imagem);
			}
		} catch (DAOException e) {
			throw new RNException("Falha ao salvar imagem.");
		}
	}

	/**
	 * Método responsávle por recuperar uma Imagem
	 * @author pedro.gregorio
	 * @param codigo
	 * @return
	 * @throws RNException
	 */
	public Imagem retrieve(Integer codigo) throws RNException {
		try {
			return (Imagem) this.dao.retrieve(Imagem.class, codigo);
		} catch (DAOException e) {
			throw new RNException("Falha ao recuperar imagem.");
		}
	}

	/**
	 * Método responsável por excluir uma Imagem através de seu objeto
	 * @author pedro.gregorio
	 * @param imagem
	 * @throws RNException
	 */
	public void delete(Imagem imagem) throws RNException {
		try {
			this.dao.delete(imagem);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao excluir imagem.");
		}
	}

	/**
	 * Método responsável por salvar/atualizar uma Imagem
	 * @author pedro.gregorio
	 * @param imagem
	 * @throws RNException
	 */
	public void saveOrUpdate(Imagem imagem) throws RNException {
		try {
			this.dao.saveOrUpdate(imagem);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException("Falha ao salvar imagem.");
		}
	}

	/**
	 * Método responsávle por retornar uma lista de Imagem
	 * @author pedro.gregorio
	 * @return
	 * @throws RNException
	 */
	@SuppressWarnings("unchecked")
	public List<Imagem> getList() throws RNException {
		
		try {
			return this.dao.list(Imagem.class, "str_nome");
		} catch (DAOException e) {
			throw new RNException("Falha ao listar imagems.");
		}
	}
}
