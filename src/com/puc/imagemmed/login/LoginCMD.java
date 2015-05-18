package com.puc.imagemmed.login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.puc.commons.exceptions.RNException;
import com.puc.commons.helpers.CriptHelper;
import com.puc.commons.message.Message;
import com.puc.commons.message.TypeMessage;
import com.puc.imagemmed.pessoa.Pessoa;
import com.puc.imagemmed.usuario.Usuario;
import com.puc.imagemmed.usuario.UsuarioRN;

/**
 * Serlvet responsável por gerenciar as requições relacionadas ao Login
 * @author pedro.gregorio
 *
 */
@WebServlet(name="Login", urlPatterns={"/Login.do"})
public class LoginCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Inicializa Servlet
	 */
	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * Realiza as mesmas funções de doPost
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	/**
	 * Seleciona a operação a ser executada
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setStr_email(req.getParameter("str_email"));
		usuario.setPessoa(pessoa);
		usuario.setStr_senha(CriptHelper.sha(req.getParameter("str_senha")));

		resp.setContentType("text/html");
		
		try {

			usuario = (new UsuarioRN()).validar(usuario);

			if (usuario!=null) {
				
				req.getSession().setAttribute("usuario", usuario);
				resp.sendRedirect("Usuario.do?o=init");
			} else {
				req.setAttribute("message", new Message("Falha ao inicializar sessão.", TypeMessage.error));
				resp.sendRedirect("login.jsp");
			}
		} catch(RNException e) {
			req.setAttribute("message", new Message("Falha ao inicializar sessão.", TypeMessage.error));
			resp.sendRedirect("login.jsp");
		}
	}
}
