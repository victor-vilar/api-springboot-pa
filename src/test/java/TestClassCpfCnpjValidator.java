import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;
import br.com.landtec.util.CpfCnpjValidator;

public class TestClassCpfCnpjValidator {

	public static void main(String[] args) {
		
		String number = "12525299701";
		
		CpfCnpjValidator.checkIfIsValid(number);
	}

}
