package co.edu.javeriana.farmaceutica.client.service;

import co.edu.javeriana.farmaceutica.client.entity.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);
    List<Client> list();
    Optional<Client> get(String id);
}
