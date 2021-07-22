package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientByEmail(String email);

    Client getClientByTelephone(String telephone);
}
