package co.edu.javeriana.farmaceutica.client.repository;

import co.edu.javeriana.farmaceutica.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}