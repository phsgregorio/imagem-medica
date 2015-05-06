package com.puc.commons.helpers;

/**
 * Classe respons�vel por auxiliar em tratamentos de inteiros
 * @author pedro.gregorio
 *
 */
public class IntegerHelper {

	/**
	 * M�todo respons�vle por parsear um inteiro atrav�s de uma String
	 * @param str
	 * @return
	 */
	public static Integer parseInt(String str){
		return (str!=null && str.length()>0) ? Integer.parseInt(str) : null;
	}
}
