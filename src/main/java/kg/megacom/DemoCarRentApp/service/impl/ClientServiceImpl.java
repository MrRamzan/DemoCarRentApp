package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.ClientRepository;
import kg.megacom.DemoCarRentApp.mappers.ClientMapper;
import kg.megacom.DemoCarRentApp.model.Client;
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
        List<Client> clientList = clientRepository.getAllByActivated(activated);
        return ClientMapper.INSTANCE.toClientDtoList(clientList);
    }

    @Override
    public List<ClientDto> getAllByEnabled(boolean enabled) {
        List<Client> clientList = clientRepository.getAllByEnabled(enabled);
        return ClientMapper.INSTANCE.toClientDtoList(clientList);
    }

    @Override
    public List<ClientDto> getAllClients() {
       List<Client> clients = clientRepository.findAll();
       return ClientMapper.INSTANCE.toClientDtoList(clients);
    }

    @Override
    public List<ClientDto> getAllByActivatedAndEnabled(boolean activated, boolean enabled) {
        List<Client> clients = clientRepository.getAllByActivatedAndEnabled(activated, enabled);
        return ClientMapper.INSTANCE.toClientDtoList(clients);
    }

    @Override
    public ClientDto getByMail(String email) {
        Client client = clientRepository.getClientByEmail(email);
        if (client == null){
            throw new RuntimeException("Client with this email was not found");
        }

        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto getByTelephone(String telephone) {
        Client client = clientRepository.getClientByTelephone(telephone);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        client = clientRepository.save(client);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public int deleteClient(Long id) {
        if (clientRepository.existsById(id)){
            Client client1 = clientRepository.getById(id);
            client1.setActivated(false);
            clientRepository.save(client1);
            return 1;
        }
        return 0;
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElse(null);
        if (client == null) {
            throw new RuntimeException("Client not found");
        }
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setMiddlename(clientDto.getMiddlename());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setTelephone(clientDto.getTelephone());
        clientRepository.save(client);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public int activatedClient(Long id) {
        if (clientRepository.existsById(id)){
            Client client1 = clientRepository.getById(id);
            client1.setActivated(true);
            clientRepository.save(client1);
            return 1;
        }
        return 0;
    }
}

