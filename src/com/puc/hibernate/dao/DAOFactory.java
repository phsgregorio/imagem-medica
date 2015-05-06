package com.puc.hibernate.dao;

import com.puc.hibernate.connection.HibernateUtil;
import com.puc.imagemmed.doenca.DoencaDAO;
import com.puc.imagemmed.doenca.DoencaDAOHibernate;
import com.puc.imagemmed.especialidade.EspecialidadeDAO;
import com.puc.imagemmed.especialidade.EspecialidadeDAOHibernate;
import com.puc.imagemmed.exame.ExameDAO;
import com.puc.imagemmed.exame.ExameDAOHibernate;
import com.puc.imagemmed.imagem.ImagemDAO;
import com.puc.imagemmed.imagem.ImagemDAOHibernate;
import com.puc.imagemmed.instituicao.InstituicaoDAO;
import com.puc.imagemmed.instituicao.InstituicaoDAOHibernate;
import com.puc.imagemmed.medico.MedicoDAO;
import com.puc.imagemmed.medico.MedicoDAOHibernate;
import com.puc.imagemmed.nota.NotaDAO;
import com.puc.imagemmed.nota.NotaDAOHibernate;
import com.puc.imagemmed.paciente.PacienteDAO;
import com.puc.imagemmed.paciente.PacienteDAOHibernate;
import com.puc.imagemmed.parente.ParenteDAO;
import com.puc.imagemmed.parente.ParenteDAOHibernate;
import com.puc.imagemmed.permissao.PermissaoDAO;
import com.puc.imagemmed.permissao.PermissaoDAOHibernate;
import com.puc.imagemmed.pessoa.PessoaDAO;
import com.puc.imagemmed.pessoa.PessoaDAOHibernate;
import com.puc.imagemmed.usuario.UsuarioDAO;
import com.puc.imagemmed.usuario.UsuarioDAOHibernate;

/**
 * Clase responsável por retornar a factory do data access object coorrespondente
 * @author pedro.gregorio
 *
 */
public class DAOFactory {

	/**
	 * Data access object for entity Instituicao
	 * @return InstituicaoDAO
	 */
	public static InstituicaoDAO getInstituicaoDAO() {
		InstituicaoDAO dao = new InstituicaoDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Medico
	 * @return MedicoDAO
	 */
	public static MedicoDAO getMedicoDAO() {
		MedicoDAO dao = new MedicoDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Pessoa
	 * @return PessoaDAO
	 */
	public static PessoaDAO getPessoaDAO() {
		PessoaDAO dao = new PessoaDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Instituicao
	 * @return InstituicaoDAO
	 */
	public static PacienteDAO getPacienteDAO() {
		PacienteDAO dao = new PacienteDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Imagem
	 * @return ImagemDAO
	 */
	public static ImagemDAO getImagemDAO() {
		ImagemDAO dao = new ImagemDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Exame
	 * @return ExameDAO
	 */
	public static ExameDAO getExameDAO() {
		ExameDAO dao = new ExameDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Doenca
	 * @return DoencaDAO
	 */
	public static DoencaDAO getDoencaDAO() {
		DoencaDAO dao = new DoencaDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Especialidade
	 * @return EspecialidadeDAO
	 */
	public static EspecialidadeDAO getEspecialidadeDAO() {
		EspecialidadeDAO dao = new EspecialidadeDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Usuario
	 * @return UsuarioDAO
	 */
	public static UsuarioDAO getUsuarioDAO() {
		UsuarioDAO dao = new UsuarioDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}

	/**
	 * Data access object for entity Permissao
	 * @return PermissaoDAO
	 */
	public static PermissaoDAO getPermissaoDAO() {
		PermissaoDAO dao = new PermissaoDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
	
	/**
	 * Data access object for entity Parente
	 * @return ParenteDAO
	 */
	public static ParenteDAO getParenteDAO() {
		ParenteDAO dao = new ParenteDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}	
	
	/**
	 * Data access object for entity Nota
	 * @return NotaDAO
	 */
	public static NotaDAO getNotaDAO() {
		NotaDAO dao = new NotaDAOHibernate();
		dao.setSession(HibernateUtil.getFactory().getCurrentSession());
		return dao;
	}
}
