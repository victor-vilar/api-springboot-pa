import com.victorvilar.projetoempresa.entities.Client;

public class TestClassCpfCnpjValidator {

	public static void main(String[] args) {
		
		String number = "12525299701";
		
		Client client = new Client("Aborgama do Brasil");
		client.setCpfCnpj("11111111111");
		
		System.out.println(client.getCpfCnpj());
	}

}
