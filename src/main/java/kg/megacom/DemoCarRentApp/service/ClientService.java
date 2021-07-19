package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients();

    ClientDto getByMail(String email);

    ClientDto getByTelephone(String telephone);

    ClientDto getById(Long id);

    ClientDto saveClient(ClientDto clientDto);

    int deleteClient(Long id);

    ClientDto update(Long id, ClientDto clientDto);

    int activateClient(Long id);

}
