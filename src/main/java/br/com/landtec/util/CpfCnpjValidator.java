package br.com.landtec.util;

import br.com.landtec.exceptions.AllNumbersAreTheSameException;
import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;
/**
 * Created to check if a valid cpf/cnpj
 * @author Victor Vilar
 * @since 2022-01-31
 */
public abstract class CpfCnpjValidator {
	
	public static boolean checkIfIsValid(String cpfCnpj) {
		boolean isValid = false;
		try{
			if(checkIfItsLength(cpfCnpj)) {
				if(cpfCnpj.length() == 11) {
					isValid =validateCpf(cpfCnpj);
				}else {
					isValid =validateCnpj(cpfCnpj);
				}
			}
			
		}catch(WrongLengthOfCpfCnpjException e) {
			System.out.println(e.getMessage());
		}catch(AllNumbersAreTheSameException e) {
			System.out.println(e.getMessage());
		}
		return isValid;
	}
	
	
	/**
	 * Check if the CPF is valid
	 * @param cpf variable that represents a cpf number
	 * @return true if it's ok;
	 */
	
	private static boolean validateCpf(String cpf) {
		
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
	
	private static boolean validateCnpj(String cnpj) {
		
		return false;
	}
	
	
	/**
	 * check the length of the string. If the string has 11 elements it's a CPF
	 * if it has 14 elements it's a CNPJ, any other number it's a invalid number
	 * @param cpfCnpj variable that represents a CPF or CNPJ.
	 */
	
	private static boolean checkIfItsLength(String cpfCnpj) throws WrongLengthOfCpfCnpjException, AllNumbersAreTheSameException {
		boolean validNumber = checkIfIsNumber(cpfCnpj);
		boolean isValidLength = false;
		if(validNumber) {
			 validNumber = checkIfAllNumbersAreEqual(cpfCnpj);
			//not because above method check if all the numbers are the same. If it is return true
			if(!validNumber) {
				if(cpfCnpj.length() == 11 || cpfCnpj.length() == 14) {
					isValidLength=true;
				}
				else {
					throw new WrongLengthOfCpfCnpjException("The number of elemets it's wrong");
				}		
			}
		}
		
		return isValidLength;
	}
		
	/**
	 * check if all numbers of variable are the same, if it is must return true;
	 * @param cpfCnpj
	 * @return 
	 */
	private static boolean checkIfAllNumbersAreEqual(String cpfCnpj) throws AllNumbersAreTheSameException{
		String[] sameCpfs = {"00000000000","11111111111","22222222222","33333333333","44444444444",
				"55555555555","66666666666","77777777777","88888888888","99999999999"};
		String[] sameCnpjs = {"00000000000000","11111111111111","22222222222222","33333333333333",
				"44444444444444","55555555555555","66666666666666","77777777777","88888888888888",
				"99999999999999"};
		
		boolean isTheSame = false;
		for(int i = 0; i < 10 ; i++) {
			if(cpfCnpj.equals(sameCpfs[i]) || cpfCnpj.equals(sameCnpjs[i])) {
				isTheSame = true;
				throw new AllNumbersAreTheSameException("All the numbers are the same, invalid input");
			}
		}
		
		return isTheSame;
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
