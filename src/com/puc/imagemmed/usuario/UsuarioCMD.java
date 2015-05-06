package com.puc.imagemmed.usuario;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.puc.commons.exceptions.RNException;
import com.puc.commons.helpers.Error;
import com.puc.commons.helpers.IntegerHelper;
import com.puc.commons.helpers.ParserHelper;
import com.puc.commons.message.Message;
import com.puc.commons.message.TypeMessage;
import com.puc.imagemmed.permissao.Permissao;
import com.puc.imagemmed.permissao.PermissaoRN;
import com.puc.imagemmed.pessoa.Pessoa;
import com.puc.imagemmed.pessoa.PessoaRN;

/**
 * Serlvet respons�vel por gerenciar as requi��es relacionadas a Usuario
 * @author 389888
 *
 */
@WebServlet(name="Usuario", urlPatterns={"/Usuario.do"})
public class UsuarioCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioRN UsuarioRn;

	private PrintWriter responseWriter;
	private String response;

	/**
	 * Inicializa Servlet
	 */
	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * Realiza as mesmas fun��es de doPost
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	/**
	 * Seleciona a opera��o a ser executada
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json; charset=UTF-8");
		String option = req.getParameter("o");
		responseWriter = resp.getWriter();

		if (option!=null) {
			
			UsuarioRn = new UsuarioRN();
			
			if (option.equals("save")) {
				save(req, resp);
			} else if (option.equals("list")) {
				list(req, resp);
			} else if (option.equals("edit")) {
				edit(req, resp);
			} else if (option.equals("dele")) {
				dele(req, resp);
			} else if (option.equals("init")) {
				init(req, resp);
			}
		} else {

			response = ParserHelper.toJson(new Error(0,"Opera��o n�o encontrada"));
			responseWriter.write(response);
		}
	}

	/**
	 * M�todo respons�vel por inicializar uma aplica��o
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void init(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setContentType("text/html");
		
		try {

			List<Pessoa> pessoas = (new PessoaRN().getList());
			List<Permissao> permissoes = (new PermissaoRN()).getList();

			req.setAttribute("pessoas", pessoas);
			req.setAttribute("permissoes", permissoes);
		} catch(RNException e) {
			req.setAttribute("message", new Message("Falha ao inicializar cadastro de usu�rios", TypeMessage.error));
		} finally{

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/usuario.jsp");
			rd.forward(req, resp);
		}
	}

	/**
	 * M�todo respons�vel por salvar/atualizar a usu�rio enviada pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		UsuarioRn = new UsuarioRN();
		Usuario usuario = new Usuario();
		
		try {

			usuario.setPessoa( (new PessoaRN()).retrieve(IntegerHelper.parseInt(req.getParameter("id_pessoa"))));
			usuario.setStr_senha(req.getParameter("str_nome"));

			UsuarioRn.save(usuario);
			response = ParserHelper.toJson(usuario);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * M�todo respons�vel por retornar a lista de usu�rios solicitadas pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			List<Usuario> usuarios = UsuarioRn.getList();
			response = ParserHelper.toJson(usuarios);
		} catch (RNException e) {
			e.printStackTrace();
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * M�todo respons�vel por retornar um registro para edi��o enviado pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		try {

			Usuario usuario = UsuarioRn.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(usuario);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O par�metro informado n�o satisfaz os crit�rios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * M�todo respons�vel por excluir o registro enviado pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void dele(HttpServletRequest req, HttpServletResponse resp) {

		try {
			
			Usuario usuario = UsuarioRn.retrieve(Integer.parseInt(req.getParameter("c")));
			(new UsuarioRN()).delete(usuario);
			response = ParserHelper.toJson(usuario);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O par�metro informado n�o satisfaz os crit�rios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
