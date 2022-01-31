import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;
import br.com.landtec.util.CpfCnpjValidator;

public class TestClassCpfCnpjValidator {

	public static void main(String[] args) {
		
		String number = "11111111111";
		
		CpfCnpjValidator.checkIfIsValid(number);
	}

}
