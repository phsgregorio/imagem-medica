package com.puc.commons.exceptions;


public class UtilException extends Exception {

	private static final long serialVersionUID = 5445740719839021608L;

	public UtilException() {
	}

	public UtilException(String arg0) {
		super(arg0);
	}

	public UtilException(Throwable arg0) {
		super(arg0);
	}

	public UtilException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}