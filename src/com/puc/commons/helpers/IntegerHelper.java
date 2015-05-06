package com.puc.commons.helpers;

/**
 * Classe responsável por auxiliar em tratamentos de inteiros
 * @author pedro.gregorio
 *
 */
public class IntegerHelper {

	/**
	 * Método responsávle por parsear um inteiro através de uma String
	 * @param str
	 * @return
	 */
	public static Integer parseInt(String str){
		return (str!=null && str.length()>0) ? Integer.parseInt(str) : null;
	}
}
