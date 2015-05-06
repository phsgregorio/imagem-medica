package com.puc.imagemmed.instituicao;


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

@WebServlet(name="Instituicao", urlPatterns={"/Instituicao.do"})
public class InstituicaoCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	private InstituicaoRN instituicaoRn;

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
		
		resp.setContentType("application/json; charset=UTF-8");
		String option = req.getParameter("o");
		responseWriter = resp.getWriter();

		if (option!=null) {
			
			instituicaoRn = new InstituicaoRN();
			
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

			response = ParserHelper.toJson(new Error(0,"Operação não encontrada"));
			responseWriter.write(response);
		}
	}
	
	/**
	 * Método responsável por inicializar uma aplicação
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void init(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setContentType("text/html");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/instituicao.jsp");
		rd.forward(req, resp);
	}

	/**
	 * Método responsável por salvar/atualizar uma instituição enviada pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		instituicaoRn = new InstituicaoRN();
		
		Instituicao instituicao = new Instituicao();
		
		instituicao.setId_instituicao(IntegerHelper.parseInt(req.getParameter("id_instituicao")));	

		instituicao.setStr_nome(req.getParameter("str_nome"));
		instituicao.setStr_descricao(req.getParameter("str_descricao"));
		instituicao.setStr_email(req.getParameter("str_email"));
		instituicao.setNum_telefone(IntegerHelper.parseInt(req.getParameter("num_telefone")));
		instituicao.setNum_fax(IntegerHelper.parseInt(req.getParameter("num_fax")));

		instituicao.setStr_endereco(req.getParameter("str_endereco"));
		instituicao.setStr_bairro(req.getParameter("str_bairro"));
		instituicao.setNum_endereco(IntegerHelper.parseInt(req.getParameter("num_endereco")));

		try {
			
			instituicaoRn.save(instituicao);
			response = ParserHelper.toJson(instituicao);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por retornar a lista de instituições solicitadas pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			List<Instituicao> instituicoes = instituicaoRn.getList();
			response = ParserHelper.toJson(instituicoes);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por retornar um registro para edição enviado pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		try {

			Instituicao instituicao = instituicaoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(instituicao);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por excluir o registro enviado pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void dele(HttpServletRequest req, HttpServletResponse resp) {

		try {
			
			Instituicao instituicao = instituicaoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			(new InstituicaoRN()).delete(instituicao);
			response = ParserHelper.toJson(instituicao);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
