package com.puc.imagemmed.pessoa;


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
import com.puc.commons.helpers.DateHelper;
import com.puc.commons.helpers.Error;
import com.puc.commons.helpers.IntegerHelper;
import com.puc.commons.helpers.ParserHelper;
import com.puc.imagemmed.pessoa.Pessoa;
import com.puc.imagemmed.pessoa.PessoaRN;

/**
 * Servlet responsável por gerenciar as requisições de Pessoas
 * @author pedro.gregorio
 *
 */
@WebServlet(name="Pessoa", urlPatterns={"/jsp/Pessoa.do"})
public class PessoaCMD extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PessoaRN pessoaRN;
	
	private PrintWriter responseWriter;
	private String response;

	/**
	 * Polimorfismo do método init da classe HttpServlet
	 */
	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * Polimorfismo do método doGet da classe HttpServlet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	/**
	 * Polimorfismo do método doPost da classe HttpServlet
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json; charset=UTF-8");
		String option = req.getParameter("o");
		PrintWriter response = resp.getWriter();

		if (option!=null) {
			
			pessoaRN = new PessoaRN();
			
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
			response.print("{ error: \"Operação não encontrada\" }");
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/pessoa.jsp");
		rd.forward(req, resp);
	}

	/**
	 * Método responsável por gerenciar uma requisição para salvar uma nova Pessoa
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		Pessoa pessoa = new Pessoa();
		
		pessoa.setId_pessoa(IntegerHelper.parseInt(req.getParameter("id_pessoa")));
		pessoa.setStr_nome(req.getParameter("str_nome"));
		pessoa.setStr_email(req.getParameter("str_email"));
		pessoa.setStr_cpf(req.getParameter("str_cpf"));
		pessoa.setNum_rg(IntegerHelper.parseInt(req.getParameter("num_rg")));
		pessoa.setDta_nascimento(DateHelper.toDate(req.getParameter("dta_nascimento")));
		pessoa.setNum_telefone(IntegerHelper.parseInt(req.getParameter("num_telefone")));
		
		if (req.getParameter("chr_sexo")!=null && req.getParameter("chr_sexo").length()==1) {
			pessoa.setChr_sexo(req.getParameter("chr_sexo").charAt(0));	
		}
		
		pessoa.setNum_cep(IntegerHelper.parseInt(req.getParameter("num_cep")));
		pessoa.setStr_endereco(req.getParameter("str_endereco"));
		pessoa.setStr_bairro(req.getParameter("str_bairro"));
		pessoa.setNum_endereco(IntegerHelper.parseInt(req.getParameter("num_endereco")));

		System.out.println("# Dados setados, pronto para o rock n roll");
		
		try {
			
			pessoaRN.save(pessoa);
			response = ParserHelper.toJson(pessoa);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por gerenciar a requisição de listagem de pessoas
	 * @param req
	 * @param resp
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			List<Pessoa> pessoas = pessoaRN.getList();
			response = ParserHelper.toJson(pessoas);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por gerenciar um requisição para edição de pessoas
	 * @param req
	 * @param resp
	 */
	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		try {

			Pessoa pessoa = pessoaRN.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(pessoa);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * Método responsável por gerenciar uma requisição para exclusão de pessoas
	 * @param req
	 * @param resp
	 */
	private void dele(HttpServletRequest req, HttpServletResponse resp) {

		try {
			
			Pessoa pessoa = pessoaRN.retrieve(Integer.parseInt(req.getParameter("c")));
			(new PessoaRN()).delete(pessoa);
			response = ParserHelper.toJson(pessoa);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
