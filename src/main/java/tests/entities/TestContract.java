package tests.entities;

import br.com.landtec.DAO.ClientDao;
import br.com.landtec.DAO.EquipamentDao;
import br.com.landtec.DAO.ResidueTypeDao;
import br.com.landtec.entities.Client;
import br.com.landtec.entities.Equipament;
import br.com.landtec.entities.ResidueType;
import br.com.landtec.util.EntityManagerBuilder;

public class TestContract {

		public static void main(String[] args) {
			
			//declaring variables
			Client clienteClient;
			Equipament equipament;
			ResidueType residue;
			
			
			//declaring daos;
			ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
			EquipamentDao equipamentDao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
			ResidueTypeDao residueDao = new ResidueTypeDao(EntityManagerBuilder.getEntityManager());
			
			
			
		}
	
	
}
