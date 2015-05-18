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
 * Serlvet responsável por gerenciar as requições relacionadas a Medico
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/medico.jsp");
		rd.forward(req, resp);
	}

	/**
	 * Método responsável por salvar/atualizar a médico enviada pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {

		// TODO pedro.gregorio Tinha que ter uma terceira classe -> PessoaSrv -> onde fosse possível passar os dados estaticamente com opção de transaction
		// TODO pedro.gregorio Bolar esse esquema para outro dia
		Pessoa pessoa;

		try {
			
			// Salva dados da pessoa para prosseguir cadastro do médico
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
	 * Método responsável por retornar a lista de médicos solicitadas pela requisição
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
	 * Método responsável por retornar um registro para edição enviado pela requisição
	 * @author pedro.gregorio
	 * @param req
	 * @param resp
	 */
	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		try {

			Medico medico = medicoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			response = ParserHelper.toJson(medico);
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
			
			Medico medico = medicoRn.retrieve(Integer.parseInt(req.getParameter("c")));
			(new MedicoRN()).delete(medico);
			response = ParserHelper.toJson(medico);
		} catch (NumberFormatException e) {
			response = ParserHelper.toJson(new Error(1, "O parâmetro informado não satisfaz os critérios de pesquisa."));
		} catch (RNException e) {
			response = ParserHelper.toJson(new Error(1, e.getMessage()));
		} finally {
			responseWriter.write(response);
		}
	}
}
