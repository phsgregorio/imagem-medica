package com.puc.commons.helpers;


import java.text.NumberFormat;

public class CurrencyHelper {
	
	public static String toSimpleCurrency(Double value) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String c = nf.format(value).split(" ")[1];
		return c;
	}
	
	public static String toCompleteCurrency(Double value) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String c = nf.format(value);
		return c;
	}
	
	public static Double toDouble(String currency) {
		String symbol = NumberFormat.getCurrencyInstance().getCurrency().getSymbol();
		if (currency == null || currency.trim().equals(""))
			return 0d;
		if(currency.trim().startsWith(symbol)) {
			currency = currency.trim().substring(symbol.length());
		}		
		return new Double(currency.trim().replace(".","").replace(",","."));
	}
}
