package tests.entities;

import java.util.ArrayList;
import java.util.List;

import com.victorvilar.projetoempresa.DAO.EquipamentDao;
import com.victorvilar.projetoempresa.DAO.ResidueTypeDao;
import com.victorvilar.projetoempresa.model.Equipament;
import com.victorvilar.projetoempresa.model.ResidueType;
import com.victorvilar.projetoempresa.util.EntityManagerBuilder;

public class TestInsertResidues {
	
	
	public static void main(String[] args) {
	
		ResidueType residuo;
		
		List<ResidueType> residuos = new ArrayList<ResidueType>();
		ResidueTypeDao dao = new ResidueTypeDao(EntityManagerBuilder.getEntityManager());
		
		//extraordinário
		residuo = new ResidueType();
		residuo.setType("Classe IIA - Extraordinário");
		residuos.add(residuo);
		
		//infectante
		residuo = new ResidueType();
		residuo.setType("Classe A e E- Infectantes e PerfuroCortantes");
		residuos.add(residuo);
		
		//entulho
		residuo = new ResidueType();
		residuo.setType("Classe IIB - Entulhos");
		residuos.add(residuo);
		
		//químico
		residuo = new ResidueType();
		residuo.setType("Classe B - Químicos");
		residuos.add(residuo);
		
		//lampadas
		residuo = new ResidueType();
		residuo.setType("Classe I - Lâmpadas");
		residuos.add(residuo);
		
		//efluentes
		residuo = new ResidueType();
		residuo.setType("Efluentes Industriais");
		residuos.add(residuo);
		
		residuos.forEach(e -> dao.saveResidue(e));
		
		
		
	}
}
