package com.puc.imagemmed.especialidade;


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

/**
 * Serlvet responsável por gerenciar as requições relacionadas a Especialidade
 * @author 389888
 *
 */
@WebServlet(name="Especialidade", urlPatterns={"/Especialidade.do"})
public class EspecialidadeCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	private EspecialidadeRN especialidadeRN;

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
			
			especialidadeRN = new EspecialidadeRN();
			
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/especialidade.jsp");
		rd.forward(req, resp);
	}

	/**
	 * Método responsável por salvar/atualizar a doença enviada pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		Especialidade especialidade = new Especialidade();
		
		especialidade.setId_especialidade(IntegerHelper.parseInt(req.getParameter("id_especialidade")));
		especialidade.setStr_nome(req.getParameter("str_nome"));
		especialidade.setStr_descricao(req.getParameter("str_descricao"));

		try {
			
			especialidadeRN.save(especialidade);
			response = ParserHelper.toJson(especialidade);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por retornar a lista de doenças solicitadas pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			List<Especialidade> especialidades = especialidadeRN.getList();
			response = ParserHelper.toJson(especialidades);
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

			Especialidade especialidade = especialidadeRN.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(especialidade);
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
			
			Especialidade especialidade = especialidadeRN.retrieve(Integer.parseInt(req.getParameter("c")));
			(new EspecialidadeRN()).delete(especialidade);
			response = ParserHelper.toJson(especialidade);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
