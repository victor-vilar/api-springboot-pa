package tests.entities;

import br.com.landtec.entities.Equipament;

public class TestEquipament {

	public static void main(String[] args) {
		
		Equipament equipamento = new Equipament();
		
		equipamento.setEquipamentName("Conteiner de 1.2m³");
		equipamento.setSizeInMeterCubic(1.2);
		
		System.out.println(equipamento.getEquipamentName());
		System.out.println(equipamento.getSizeInMeterCubic());
		
	}
}
