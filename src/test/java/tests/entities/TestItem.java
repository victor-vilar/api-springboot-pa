package tests.entities;

import com.victorvilar.projetoempresa.domain.Equipment;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.domain.ResidueType;

public class TestItem {

	public static void main(String[] args) {
		
		
		Equipment equipamento = new Equipment();
		ResidueType residuo = new ResidueType();
		
		
		equipamento.setEquipmentName("Conteiner de 1.2m�");
		equipamento.setSizeInMeterCubic(1.2);
		
		residuo.setType("Lixo Extraordin�rio");
		residuo.setDescription("Coleta transporte e destina��o final de " + residuo.getType() + ".\n"
				+ "em caminhoes compactores");
		
		ItemContract item = new ItemContract();
		item.setEquipament(equipamento);
		item.setResidue(residuo);
		item.setQtdOfResidue(300.00);
		item.setValue(157.00);
		
		
		System.out.println(item);
		
	}
}
