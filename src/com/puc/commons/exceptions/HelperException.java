package com.puc.commons.exceptions;


public class HelperException extends Exception {

	private static final long serialVersionUID = 6141027787543709142L;

	public HelperException(String message) {
		super(message);
	}

	public HelperException(Throwable cause) {
		super(cause);
	}

	public HelperException(String message, Throwable cause) {
		super(message, cause);
	}
}
