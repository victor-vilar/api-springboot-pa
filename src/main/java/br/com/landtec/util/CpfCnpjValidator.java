package br.com.landtec.util;

import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;
/**
 * Created to check if a valid cpf/cnpj
 * @author Victor Vilar
 * @since 2022-01-31
 */
public abstract class CpfCnpjValidator {
	
	public static boolean checkIfIsValid(String cpfCnpj) {
		boolean isValid =false;
		try{
			if(checkIfItsLength(cpfCnpj)) {
				if(cpfCnpj.length() == 11) {
					isValid =validadeCpf(cpfCnpj);
				}else {
					isValid =validadeCnpj(cpfCnpj);
				}
			}
			
		}catch(WrongLengthOfCpfCnpjException e) {
			System.out.println(e.getMessage());
		}
		
		return isValid;
	}
	
	
	
	
	public static boolean validadeCpf(String cpf) {
		
		String[] numbers = cpf.split("");
		int cont = 10;
		int sum = 0;
		
		//validade the first digit
		for(int i = 0; i <= 8; i++) {
			sum += Integer.parseInt(numbers[i]) * cont;
			cont--;
		}
		
		// if the rest of division equals 10 then turn sum to 0(zero)
		// if num != of first digit so the cpf it's wrong, return false.
		sum = (sum *10) % 11;
		if(sum == 10) sum = 0;
		if(sum != Integer.parseInt(numbers[9])) return false;
		//--------------------------
		
		
		cont = 11;
		sum = 0;
		//validade the second digit
		for(int i = 0; i <= 9; i++) {
			sum += Integer.parseInt(numbers[i]) * cont;
			cont--;
		}
		
		// if the rest of division equals 10 then turn sum to 0(zero)
		// if num != of first digit so the cpf it's wrong, return false.
		sum = (sum *10) % 11;
		if(sum == 10) sum = 0;
		if(sum != Integer.parseInt(numbers[10])) return false;
		//--------------------------
		System.out.println("Cpf Valido");
		return true;
		
	}
	
	private static boolean validadeCnpj(String cnpj) {
		
		return false;
	}
	
	
	/**
	 * check the length of the string. If the string has 11 elements it's a CPF
	 * if it has 14 elements it's a CNPJ, any other number it's a invalid number
	 * @param cpfCnpj variable that represents a CPF or CNPJ.
	 */
	
	private static boolean checkIfItsLength(String cpfCnpj) throws WrongLengthOfCpfCnpjException {
		boolean validNumber = checkIfIsNumber(cpfCnpj);
		boolean isValidLength = false;
		if(validNumber) {
			
			if(cpfCnpj.length() == 11 || cpfCnpj.length() == 14) {
				isValidLength=true;
			}
			else {
				throw new WrongLengthOfCpfCnpjException("The number of elemets it's wrong");

			}		
		}
		
		return isValidLength;
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
