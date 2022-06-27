package com.victorvilar.projetoempresa.exceptions;

public class InvalidCpfOrCnpjException extends Exception {
	
	public InvalidCpfOrCnpjException(String error) {
		super(error);
	}

}
