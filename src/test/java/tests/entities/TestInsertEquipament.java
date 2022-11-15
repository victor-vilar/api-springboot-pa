package tests.entities;

import java.util.ArrayList;
import java.util.List;

import com.victorvilar.projetoempresa.DAO.EquipamentDao;
import com.victorvilar.projetoempresa.domain.Equipament;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestInsertEquipament {

	public static void main(String[] args) {
		
		Equipament equipamento;

		List<Equipament> equipamentos = new ArrayList<Equipament>();
		EquipamentDao dao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
		
		//30 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Ca�amba de 30m�");
		equipamento.setSizeInMeterCubic(30);
		equipamentos.add(equipamento);
		equipamento = null;
		
		//5 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Container 1.2m�");
		equipamento.setSizeInMeterCubic(1.2);
		equipamentos.add(equipamento);
		equipamento = null;
		
		//1.2 meters Container
		equipamento = new Equipament();
		equipamento.setEquipamentName("Container 1.2m�");
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
