package com.puc.commons.helpers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.Normalizer;

public class StringHelper {
	
	public static String removerAcentos(String s) {
		CharSequence cs = new StringBuilder(s == null ? "" : s);  
		return Normalizer.normalize(cs, Normalizer.Form.NFKD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
	
	public static String removerEspacos(String s) {
		CharSequence cs = new StringBuilder(s == null ? "" : s);  
		return Normalizer.normalize(cs, Normalizer.Form.NFKD)
				.replaceAll("\\s+", "");
	}
	
	public static String trocaEspacosPorUnderline(String s) {
		CharSequence cs = new StringBuilder(s == null ? "" : s);  
		return Normalizer.normalize(cs, Normalizer.Form.NFKD)
				.replaceAll("\\s+", "_");
	}
	
	public static String random() {
		return new BigInteger(130, new SecureRandom()).toString(32);
	}
	
	public static Boolean isEmpty(String s) {
		return s==null || removerEspacos(s).length()==0;
	}
	
	public static Boolean isNotEmpty(String s){
		return !isEmpty(s);
	}
}