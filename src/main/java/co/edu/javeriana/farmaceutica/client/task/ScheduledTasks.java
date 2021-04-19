package co.edu.javeriana.farmaceutica.client.task;

import co.edu.javeriana.farmaceutica.client.client.ClientClientService;
import co.edu.javeriana.farmaceutica.client.entity.Client;
import co.edu.javeriana.farmaceutica.client.message.ClientsResponse;
import co.edu.javeriana.farmaceutica.client.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ScheduledTasks {

    private final ClientService clientService;
    private final ClientClientService clientClientService;

    @Scheduled(cron = "0 0/2 * * * ?")
    public void clientSync() {
        log.info("Sincronizando clientes");
        List<Client> clients = new ArrayList<>();
        ClientsResponse res = clientClientService.list();
        res.getClients().forEach(c -> {
            Client client = new Client();
            client.setId(c.getId());
            client.setDocumentType(c.getDocumentType());
            client.setDocument(c.getDocument());
            client.setEmail(c.getEmail());
            client.setName(c.getName());
            clients.add(client);
        });
        clientService.sync(clients);
    }
}
