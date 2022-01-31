package br.com.landtec.util;

import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;

public abstract class CpfCnpjValidator {

	
	private static void validadeCpf(String cpf) {
		
	}
	
	private static void validadeCnpj(String cnpj) {
		
	}
	
	
	
	
	/**
	 * check the length of the string. If the string has 11 elements it's a CPF
	 * if it has 14 elements it's a CNPJ, any other number it's a invalid number
	 * @param cpfCnpj variable that represents a CPF or CNPJ.
	 */
	
	public static void checkIfIsCpfOrCnpj(String cpfCnpj) throws WrongLengthOfCpfCnpjException {
		boolean valid = checkIfIsNumber(cpfCnpj);
		if(valid) {
			if(cpfCnpj.length() == 11) {
				validadeCpf(cpfCnpj);
			}
			else if(cpfCnpj.length() == 14) {
				validadeCnpj(cpfCnpj);
			}
			else {
				throw new WrongLengthOfCpfCnpjException("The number of elemets it's wrong");
			}
			
		}
	}
		
	
	/**
	 * check if the string is a valid number
	 * @param cpfCnpj
	 * @return true false variable
	 */
	private static boolean checkIfIsNumber(String cpfCnpj) {
		boolean isValid = false;
		try {
			Double.parseDouble(cpfCnpj);
			isValid = true;
		}catch(NumberFormatException e) {
			System.out.println("This is not a valid CPF or CNPJ");
		}
		return isValid;
		
	}
}
