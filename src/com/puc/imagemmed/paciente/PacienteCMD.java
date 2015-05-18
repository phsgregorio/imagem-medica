package com.puc.imagemmed.paciente;


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
 * Serlvet responsável por gerenciar as requições relacionadas a Paciente
 * @author pedro.gregorio
 *
 */
@WebServlet(name="Paciente", urlPatterns={"/Paciente.do"})
public class PacienteCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	private PacienteRN pacienteRN;

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
			
			pacienteRN = new PacienteRN();
			
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
			} else if (option.equals("upload")) {
				upload(req, resp);
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/paciente.jsp");
		
		// TODO pedro.gregorio Linhas abaixo inseridas apenas para testes(remover quando o cadastro do Paciente for corretamente implementado)
		try {
			Paciente paciente = pacienteRN.retrieve(1);
			req.setAttribute("paciente", paciente);
		} catch (RNException e) {
			e.printStackTrace();
		}

		rd.forward(req, resp);
	}

	/**
	 * Método responsável por salvar/atualizar a doença enviada pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		Paciente paciente = new Paciente();
		paciente.setId_paciente(IntegerHelper.parseInt(req.getParameter("id_paciente")));

		try {
			
			pacienteRN.save(paciente);
			response = ParserHelper.toJson(paciente);
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
			
			List<Paciente> pacientes = pacienteRN.getList();
			response = ParserHelper.toJson(pacientes);
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

			Paciente paciente = pacienteRN.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(paciente);
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
			
			Paciente paciente = pacienteRN.retrieve(Integer.parseInt(req.getParameter("c")));
			(new PacienteRN()).delete(paciente);
			response = ParserHelper.toJson(paciente);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
	
	/**
	 * Método responsável fazer o upload de uma imagem médica relacionada ao paciente
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void upload(HttpServletRequest req, HttpServletResponse resp) {

		try {

			// Recupera o paciente sendo editado
			Paciente paciente = pacienteRN.retrieve(Integer.parseInt(req.getParameter("id_paciente")));

			// Upload do arquivo de forma singular
			PacienteSVC.singleFileUpload(paciente, req);
			
			response = ParserHelper.toJson(paciente);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}	
}