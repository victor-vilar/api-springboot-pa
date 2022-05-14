package br.com.empresa.exceptions;

public class WrongLengthOfCpfCnpjException extends Exception {

	public WrongLengthOfCpfCnpjException(String errorMessage) {
		super(errorMessage);
	}
}
