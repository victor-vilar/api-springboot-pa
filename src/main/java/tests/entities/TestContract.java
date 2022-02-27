package tests.entities;

import br.com.landtec.DAO.ClientDao;
import br.com.landtec.DAO.EquipamentDao;
import br.com.landtec.DAO.ResidueTypeDao;
import br.com.landtec.entities.Client;
import br.com.landtec.entities.Contract;
import br.com.landtec.entities.Equipament;
import br.com.landtec.entities.ItemContract;
import br.com.landtec.entities.ResidueType;
import br.com.landtec.util.EntityManagerBuilder;

public class TestContract {

		public static void main(String[] args) {
			
			//declaring variables
			Client client;
			Equipament equipament;
			ResidueType residue;
			Contract contract = new Contract();
		
			
			//declaring daos;
			ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
			EquipamentDao equipamentDao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
			ResidueTypeDao residueDao = new ResidueTypeDao(EntityManagerBuilder.getEntityManager());
			
			//set variables
			client = clientDao.findClient(1l);
			equipament = equipamentDao.getAllClients().get(0);
			residue = residueDao.
			
			contract.addNewItem(new ItemContract(residue,equipament,200.00,157.00));
			contract.addNewItem(new ItemContract(residue,equipament,200.00,157.00));
			
			
			
		}
	
	
}
