package tests.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.empresa.DAO.EquipamentDao;
import br.com.empresa.entities.Equipament;
import br.com.empresa.util.EntityManagerBuilder;

public class TestInsertEquipament {

	public static void main(String[] args) {
		
		Equipament equipamento;

		List<Equipament> equipamentos = new ArrayList<Equipament>();
		EquipamentDao dao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
		
		//30 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Caçamba de 30m³");
		equipamento.setSizeInMeterCubic(30);
		equipamentos.add(equipamento);
		equipamento = null;
		
		//5 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Container 1.2m³");
		equipamento.setSizeInMeterCubic(1.2);
		equipamentos.add(equipamento);
		equipamento = null;
		
		//1.2 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Container 1.2m³");
		equipamento.setSizeInMeterCubic(1.2);
		equipamentos.add(equipamento);
		equipamento = null;
		
		//0.24 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Container 240L");
		equipamento.setSizeInMeterCubic(.24);
		equipamentos.add(equipamento);
		equipamento = null;
		
		equipamentos.forEach(e -> dao.saveEquipament(e));
		
		
		
		
	}
}
