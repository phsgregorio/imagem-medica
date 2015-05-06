package com.puc.commons.exceptions;


public class DAOException extends Exception {

	private static final long serialVersionUID = 550661196946405901L;

	public DAOException() {
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
