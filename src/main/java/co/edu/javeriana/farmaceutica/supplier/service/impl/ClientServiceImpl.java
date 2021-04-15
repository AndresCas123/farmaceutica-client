package co.edu.javeriana.farmaceutica.supplier.service.impl;

import co.edu.javeriana.farmaceutica.supplier.entity.Client;
import co.edu.javeriana.farmaceutica.supplier.repository.ClientRepository;
import co.edu.javeriana.farmaceutica.supplier.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> get(String id) {
        return clientRepository.findById(id);
    }
}