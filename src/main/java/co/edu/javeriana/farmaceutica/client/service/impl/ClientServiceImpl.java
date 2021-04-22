package co.edu.javeriana.farmaceutica.client.service.impl;

import co.edu.javeriana.farmaceutica.client.adapter.ClientAdapter;
import co.edu.javeriana.farmaceutica.client.client.ClientClientService;
import co.edu.javeriana.farmaceutica.client.entity.Client;
import co.edu.javeriana.farmaceutica.client.message.ClientsResponse;
import co.edu.javeriana.farmaceutica.client.repository.ClientRepository;
import co.edu.javeriana.farmaceutica.client.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientClientService clientClientService;
    private final ClientAdapter clientAdapter;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> list() {
        List<Client> clients = new ArrayList<>();
        try {
            ClientsResponse res = clientClientService.list();
            log.info("Loading clients from ERP");
            clients = clientAdapter.adapter(res);
            clientRepository.saveAll(clients);
        } catch(Exception e) {
            log.info("Loading clients from local cache");
            clients = clientRepository.findAll();
            log.warn(e.getMessage());
        }
        return clients;
    }

    @Override
    public Optional<Client> get(String id) {
        List<Client> clients = clientRepository.findAll();
        if(clients.isEmpty()) {
            clients = list();
        }
        return clients.stream().filter(client -> client.getId().equals(id)).findFirst();
    }
}
