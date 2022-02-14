import br.com.landtec.DAO.ClientDao;
import br.com.landtec.entities.Client;

import java.sql.SQLOutput;
import java.util.List;

public class TestPersistClientDataBase {
    public static void main(String[] args) {

        ClientDao dao = new ClientDao();
        List<Client> clients = dao.getAllClients();

        for(Client e : clients){
            System.out.println(e.toString());

        }



    }
}
