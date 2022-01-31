import br.com.landtec.exceptions.WrongLengthOfCpfCnpjException;
import br.com.landtec.util.CpfCnpjValidator;

public class TestClassCpfCnpjValidator {

	public static void main(String[] args) {
		
		String number = "0845483600017855";
		
		try {
			CpfCnpjValidator.checkIfIsCpfOrCnpj(number);
		}catch(WrongLengthOfCpfCnpjException e) {
			System.out.println(e.getMessage());
		}
	}

}
