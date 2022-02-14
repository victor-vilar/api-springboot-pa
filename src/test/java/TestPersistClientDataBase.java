import br.com.landtec.DAO.ClientDao;
import br.com.landtec.entities.Client;

public class TestPersistClientDataBase {
    public static void main(String[] args) {

        ClientDao dao = new ClientDao();
        Client client = new Client("My Company");

        dao.saveClient(client);


    }
}
