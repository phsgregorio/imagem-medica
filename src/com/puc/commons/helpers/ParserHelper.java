package com.puc.commons.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParserHelper {
	
	public static String toJson(Object a) {
		Gson gson =  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		return gson.toJson(a);
	}
	
	public static Object toObject(String jsonString, Class<?> classType) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, classType);
	}
}
