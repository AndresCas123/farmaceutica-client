package co.edu.javeriana.farmaceutica.client.client.impl;

import co.edu.javeriana.farmaceutica.client.client.ClientClientService;
import co.edu.javeriana.farmaceutica.client.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ERPClientClientService implements ClientClientService {

    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    public List<Client> list() {
        String endpoint = String.format("%s/clients", erpUrl);
        return Arrays.asList(restTemplate.getForObject(endpoint, Client[].class));
    }
}
