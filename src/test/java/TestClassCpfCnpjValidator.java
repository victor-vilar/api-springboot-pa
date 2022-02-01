import br.com.landtec.entities.Client;

public class TestClassCpfCnpjValidator {

	public static void main(String[] args) {
		
		String number = "12525299701";
		
		Client client = new Client("Aborgama do Brasil");
		client.setCpfCnpj("09478089000170");
		
		System.out.println(client.getCpfCnpj());
	}

}
