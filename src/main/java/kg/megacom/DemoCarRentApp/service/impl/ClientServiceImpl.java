package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.ClientRepository;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientDto> getAllByActivated(boolean activated) {
        return null;
    }

    @Override
    public List<ClientDto> getAllByEnabled(boolean enabled) {
        return null;
    }

    @Override
    public List<ClientDto> getAllClients() {
        return null;
    }

    @Override
    public List<ClientDto> getAllByActivatedAndEnabled(boolean activated, boolean enabled) {
        return null;
    }

    @Override
    public ClientDto getByMail(String email) {
        return null;
    }

    @Override
    public ClientDto getByTelephone(String telephone) {
        return null;
    }

    @Override
    public ClientDto getById(Long id) {
        return null;
    }

    @Override
    public void saveClient(ClientDto clientDto) {

    }

    @Override
    public void deleteClient(boolean activated) {

    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return null;
    }
}
