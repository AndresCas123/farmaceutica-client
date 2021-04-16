package co.edu.javeriana.farmaceutica.client.task;

import co.edu.javeriana.farmaceutica.client.client.ClientClientService;
import co.edu.javeriana.farmaceutica.client.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ScheduledTasks {

    private final ClientService clientService;
    private final ClientClientService clientClientService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void clientSync() {
        log.info("Sincronizando clientes");
        clientService.sync(clientClientService.list());
    }
}
