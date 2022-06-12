import java.util.List;

import com.victorvilar.projetoempresa.DAO.ClientDao;
import com.victorvilar.projetoempresa.entities.Client;

public class TestPersistClientDataBase {
    public static void main(String[] args) {

        ClientDao dao = new ClientDao();
        List<Client> clients = dao.getAllClients();

        for(Client e : clients){
            System.out.println(e.toString());

        }



    }
}
