package com.puc.imagemmed.usuario;

import com.puc.commons.exceptions.DAOException;
import com.puc.hibernate.dao.DAO;


public interface UsuarioDAO extends DAO{

	Usuario validate(Class<Usuario> class1, Usuario usuario) throws DAOException;
}
