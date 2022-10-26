package com.appointment.booking.exception;

import java.io.Serializable;

public class AppException extends RuntimeException implements Serializable {

	private ErrorCodes errorCodes;

	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(ErrorCodes errorCodes) {
		this.errorCodes = errorCodes;
	}

	public AppException(ErrorCodes errorCodes) {
		super();
		this.errorCodes = errorCodes;
	}
	

}
