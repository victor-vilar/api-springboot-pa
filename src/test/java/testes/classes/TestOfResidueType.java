package testes.classes;
import br.com.landtec.entities.ResidueType;

public class TestOfResidueType {
	
	
	
	public static void main(String[] args) {
	
		ResidueType rt = new ResidueType();
		
		rt.setType("Lixo Extraordinário");
		rt.setDescription("Coleta transporte e destinação final de " + rt.getType() + ".\n"
				+ "em caminhoes compactores");
		
		System.out.println(rt.getType());
		System.out.println(rt.getDescription());
		
	}
}
