package co.edu.javeriana.farmaceutica.client.client.impl;

import co.edu.javeriana.farmaceutica.client.client.ClientClientService;
import co.edu.javeriana.farmaceutica.client.message.ClientsResponse;
import lombok.RequiredArgsConstructor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ERPClientClientService implements ClientClientService {

    @Value("${erp.url}")
    private String erpUrl;

    private final RestTemplate restTemplate;

    public ClientsResponse list() {
        String endpoint = String.format("%s/clients", erpUrl);
        String res = restTemplate.getForObject(endpoint, String.class);
        Serializer serializer = new Persister();
        try {
            return serializer.read(ClientsResponse.class, res, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
