package tests.entities;

import java.time.LocalDate;

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
			contract.setNumber("04/2021");
			contract.setValidity(LocalDate.now());
		
			
			//declaring daos;
			ClientDao clientDao = new ClientDao(EntityManagerBuilder.getEntityManager());
			EquipamentDao equipamentDao = new EquipamentDao(EntityManagerBuilder.getEntityManager());
			ResidueTypeDao residueDao = new ResidueTypeDao(EntityManagerBuilder.getEntityManager());
			
			//set variables
			client = clientDao.findClient(1l);
			
			//item1
			equipament = equipamentDao.getAllEquipaments().get(0);
			residue = residueDao.getAllResidues().get(0);
			contract.addNewItem(new ItemContract(residue,equipament,200.00,157.00));
			
			//item2
			equipament = equipamentDao.getAllEquipaments().get(1);
			residue = residueDao.getAllResidues().get(1);
			contract.addNewItem(new ItemContract(residue,equipament,100.00,800.00));
			
			client.addNewContract(contract);
			
			clientDao.updateClient(client);
			
			
			
		}
	
	
}
