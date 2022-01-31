package br.com.landtec.exceptions;

public class WrongLengthOfCpfCnpjException extends Exception {

	public WrongLengthOfCpfCnpjException(String errorMessage) {
		super(errorMessage);
	}
}
