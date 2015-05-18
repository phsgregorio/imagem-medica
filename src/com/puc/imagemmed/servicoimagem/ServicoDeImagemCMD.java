package com.puc.imagemmed.servicoimagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.puc.commons.globals.Globals;
import com.puc.commons.helpers.Dcm4che2Helper;
import com.puc.commons.helpers.StringHelper;

/**
 * Serlvet responsável por gerenciar as requições a imagens disponíveis no servidor
 * @author pedro.gregorio
 *
 */
@WebServlet(name="ServicoDeImagem", urlPatterns={"/ServicoDeImagem.do"})
public class ServicoDeImagemCMD extends HttpServlet{
	
	private Integer id;
	private String img;
	private String dir;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Setando conteúdo da resposta
		resp.setContentType("image/jpeg");
		
		try {
			initParams(req);
		} catch (Exception e) {
			// Erro ao inicializar serviço
			throw new ServletException("Erro ao inicializar serviço. "+e.getMessage());
		}

		File fileToRetrieve = new File(getDir() + getImg());
		
		if (fileToRetrieve.isFile()) {
			
			// Se houver necessidade de converter o arquivo
			if (Dcm4che2Helper.isDcmFile(fileToRetrieve)) {
				fileToRetrieve = Dcm4che2Helper.convertDcmToJpeg(getDir(), getImg());
			}
			
			// Retornando resposta do serviço
			BufferedImage buff = ImageIO.read(fileToRetrieve);
			OutputStream out = resp.getOutputStream();
			ImageIO.write(buff, "jpg", out);
			out.close();
		} else {
			throw new ServletException("Arquivo não encontrado.");
		}		
	}

	/**
	 * Inicializa os parametros do serviço
	 * @param req
	 * @throws Exception 
	 */
	private void initParams(HttpServletRequest req) throws Exception {
		
		if (StringHelper.isEmpty(req.getParameter("id")) || StringHelper.isEmpty(req.getParameter("img"))) {
			throw new Exception("Parâmetros obrigatórios não informados");
		} else {
			setId(Integer.parseInt(req.getParameter("id")));
			setImg(req.getParameter("img"));
			setDir(Globals.PATIENT_FILE_DIR + Globals.FILE_SEPARATOR + getId() + Globals.FILE_SEPARATOR);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}