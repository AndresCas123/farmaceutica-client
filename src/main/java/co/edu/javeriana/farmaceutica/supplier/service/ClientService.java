package co.edu.javeriana.farmaceutica.supplier.service;

import co.edu.javeriana.farmaceutica.supplier.entity.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);
    List<Client> list();
    Optional<Client> get(String id);
}
