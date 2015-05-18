package com.puc.imagemmed.paciente;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import com.puc.commons.globals.Globals;

/**
 * Classe responsável oferecer métodos úteis associados ao paciente
 * @author pedro.gregorio
 *
 */
public class PacienteSVC {
	
	private static final int BUF_SIZE = 2 * 1024;

	/**
	 * Método responsável por fazer o upload de uma imagem SO através do plugin Plupload(um arquivo por requisição)
	 * @param paciente
	 * @param image
	 * @return
	 */
	public static Boolean singleFileUpload(Paciente paciente, HttpServletRequest request) {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request),
				returnResponse = false;
		
		if(isMultipart){

			ServletFileUpload upload = new ServletFileUpload();
			
			try {
				
				FileItemIterator iter = upload.getItemIterator(request);
				
				while (iter.hasNext()) {
					
				    FileItemStream item = iter.next();
				    InputStream input = item.openStream();

				    // Se não é um campo do formulário
				    if(!item.isFormField()){

				    	String fileDir = Globals.PATIENT_FILE_DIR + Globals.FILE_SEPARATOR + paciente.getId_paciente();
						File dstFile = new File(fileDir);

						if (!dstFile.exists()){
							dstFile.mkdirs();
						}
						
						File dst = new File(dstFile.getPath() + Globals.FILE_SEPARATOR + item.getName());
				        saveUploadFile(input, dst);
				    }
				    
				    returnResponse = true;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return returnResponse;
	}

	/**
	 * Método responsável por salvar o arquivo no sistema operacional
	 * @param input
	 * @param dst
	 * @throws IOException
	 */
	private static void saveUploadFile(InputStream input, File dst) throws IOException {
		OutputStream out = null;
		
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true), PacienteSVC.BUF_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst), PacienteSVC.BUF_SIZE);
			}

			byte[] buffer = new byte[PacienteSVC.BUF_SIZE];
			int len = 0;
			while ((len = input.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}