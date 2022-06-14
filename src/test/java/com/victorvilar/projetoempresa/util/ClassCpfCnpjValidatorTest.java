package com.victorvilar.projetoempresa.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.victorvilar.projetoempresa.exceptions.AllNumbersAreTheSameException;
import com.victorvilar.projetoempresa.exceptions.WrongLengthOfCpfCnpjException;

public class ClassCpfCnpjValidatorTest {


	//passing a valid cpf
	@Test
	public void checkIfIsValidTestSendingCpfAsParamMustReturnTrue() {
		Assertions.assertEquals(true, CpfCnpjValidator.checkIfIsValid("12525299701"));
	}
	
	//passing a valid cnpj
	@Test
	public void chechIfIsValidSendingCnpjAsParamMustReturnTrue() {
		Assertions.assertEquals(true, CpfCnpjValidator.checkIfIsValid("08454836000178"));
	}
	
	//passing a invalid cpf
	@Test
	public void checkIfIsValidWrongCpfMustReturnFalse() {
		Assertions.assertEquals(false, CpfCnpjValidator.checkIfIsValid("12525299700"));
	}
	
	//passing a invalid cnpj
	@Test
	public void checkIfIsValidWrongCnpjMustReturnFalse() {
		Assertions.assertEquals(false, CpfCnpjValidator.checkIfIsValid("08454836000174"));
	}
	
	
}
