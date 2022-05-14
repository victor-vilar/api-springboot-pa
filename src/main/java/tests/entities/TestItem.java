package tests.entities;

import br.com.empresa.entities.Equipament;
import br.com.empresa.entities.ItemContract;
import br.com.empresa.entities.ResidueType;

public class TestItem {

	public static void main(String[] args) {
		
		
		Equipament equipamento = new Equipament();
		ResidueType residuo = new ResidueType();
		
		
		equipamento.setEquipamentName("Conteiner de 1.2m³");
		equipamento.setSizeInMeterCubic(1.2);
		
		residuo.setType("Lixo Extraordinário");
		residuo.setDescription("Coleta transporte e destinação final de " + residuo.getType() + ".\n"
				+ "em caminhoes compactores");
		
		ItemContract item = new ItemContract();
		item.setEquipament(equipamento);
		item.setResidue(residuo);
		item.setQtdOfResidue(300.00);
		item.setValue(157.00);
		
		
		System.out.println(item);
		
	}
}
