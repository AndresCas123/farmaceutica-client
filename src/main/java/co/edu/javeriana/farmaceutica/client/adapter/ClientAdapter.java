package co.edu.javeriana.farmaceutica.client.adapter;

import co.edu.javeriana.farmaceutica.client.entity.Client;
import co.edu.javeriana.farmaceutica.client.message.ClientsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientAdapter {
    public List<Client> adapter(ClientsResponse clientsResponse) {
        List<Client> clients = new ArrayList<>();
        clientsResponse.getClients().forEach(c -> {
            Client client = new Client();
            client.setId(c.getId());
            client.setDocumentType(c.getDocumentType());
            client.setDocument(c.getDocument());
            client.setEmail(c.getEmail());
            client.setName(c.getName());
            clients.add(client);
        });
        return clients;
    }
}
