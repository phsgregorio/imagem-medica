package com.puc.imagemmed.usuario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.puc.commons.exceptions.DAOException;
import com.puc.hibernate.dao.DAOHibernate;

@SuppressWarnings({ "deprecation", "unused" })
public class UsuarioDAOHibernate extends DAOHibernate implements UsuarioDAO {

	@Override
	public Usuario validate(Class<Usuario> clazz, Usuario usuario)throws DAOException{
		
		try {
			
			this.transaction = this.session.beginTransaction();

			Criteria c = this.session.createCriteria(clazz, "usuario");
			c.createAlias("usuario.pessoa", "pessoa");
			c.add(Restrictions.eq("pessoa.str_email", usuario.getPessoa().getStr_email()));
			c.add(Restrictions.eq("str_senha", usuario.getStr_senha()));
			
			@SuppressWarnings("rawtypes")
			List usuarios = c.list();
			
			this.transaction.commit();

			return (usuarios.size()==1) ? (Usuario) usuarios.get(0) : null;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
}
