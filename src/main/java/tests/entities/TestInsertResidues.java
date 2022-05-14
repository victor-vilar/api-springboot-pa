package tests.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.empresa.DAO.EquipamentDao;
import br.com.empresa.DAO.ResidueTypeDao;
import br.com.empresa.entities.Equipament;
import br.com.empresa.entities.ResidueType;
import br.com.empresa.util.EntityManagerBuilder;

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
