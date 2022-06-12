package com.victorvilar.projetoempresa.exceptions;

public class WrongLengthOfCpfCnpjException extends Exception {

	public WrongLengthOfCpfCnpjException(String errorMessage) {
		super(errorMessage);
	}
}
