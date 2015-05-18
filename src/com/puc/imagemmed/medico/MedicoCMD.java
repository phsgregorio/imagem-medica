package com.puc.imagemmed.medico;


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
import com.puc.commons.helpers.StringHelper;
import com.puc.imagemmed.instituicao.Instituicao;
import com.puc.imagemmed.pessoa.Pessoa;
import com.puc.imagemmed.pessoa.PessoaCMD;
import com.puc.imagemmed.pessoa.PessoaRN;

/**
 * Serlvet respons�vel por gerenciar as requi��es relacionadas a Medico
 * @author pedro.gregorio
 *
 */
@WebServlet(name="Medico", urlPatterns={"/Medico.do"})
public class MedicoCMD extends HttpServlet{

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1L;
	private MedicoRN medicoRn;

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
			
			medicoRn = new MedicoRN();
			
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/medico.jsp");
		rd.forward(req, resp);
	}

	/**
	 * M�todo respons�vel por salvar/atualizar a m�dico enviada pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		// TODO pedro.gregorio Tinha que ter uma terceira classe -> PessoaSrv -> onde fosse poss�vel passar os dados estaticamente com op��o de transaction
		// TODO pedro.gregorio Bolar esse esquema para outro dia
		Pessoa pessoa;

		try {
			
			// Salva dados da pessoa para prosseguir cadastro do m�dico
			if (StringHelper.isNotEmpty(req.getParameter("salva_pessoa"))) {
				
				PessoaCMD pessoaCMD = new PessoaCMD();
				pessoa = pessoaCMD.savePessoa(req, resp);
			} else {
				
				PessoaRN pessoaRN = new PessoaRN();
				pessoa = pessoaRN.retrieve(Integer.parseInt(req.getParameter("id_pessoa")));
			}

			System.out.println(pessoa);

			Medico medico = new Medico();
			medico.setId_medico(IntegerHelper.parseInt(req.getParameter("id_medico")));
			medico.setPessoa(pessoa);
			medico.setId_instituicao(Instituicao.ID_INSTITUICAO_IMED);

			medicoRn.save(medico);
			response = ParserHelper.toJson(medico);
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1,e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}

	/**
	 * M�todo respons�vel por retornar a lista de m�dicos solicitadas pela requisi��o
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			List<Medico> medicos = medicoRn.getList();
			response = ParserHelper.toJson(medicos);
		} catch (RNException e) {
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

			Medico medico = medicoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(medico);
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
			
			Medico medico = medicoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			(new MedicoRN()).delete(medico);
			response = ParserHelper.toJson(medico);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O par�metro informado n�o satisfaz os crit�rios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
