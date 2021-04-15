package co.edu.javeriana.farmaceutica.supplier.repository;

import co.edu.javeriana.farmaceutica.supplier.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}