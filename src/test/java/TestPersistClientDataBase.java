import java.util.List;

import br.com.empresa.DAO.ClientDao;
import br.com.empresa.entities.Client;

public class TestPersistClientDataBase {
    public static void main(String[] args) {

        ClientDao dao = new ClientDao();
        List<Client> clients = dao.getAllClients();

        for(Client e : clients){
            System.out.println(e.toString());

        }



    }
}
