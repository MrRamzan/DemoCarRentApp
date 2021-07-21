package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.ClientRepository;
import kg.megacom.DemoCarRentApp.exceptions.ClientException;
import kg.megacom.DemoCarRentApp.mappers.ClientMapper;
import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.Orders;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getAllClients() {
       List<Client> clients = clientRepository.findAll();
       return ClientMapper.INSTANCE.toClientDtoList(clients);
    }

    @Override
    public ClientDto getByMail(String email) {
        Client client = clientRepository.getClientByEmail(email);
        if (client == null){
            return null;
            //throw new ClientException("Client with this email was not found");
//            Client client1 = new Client();
//            return ClientMapper.INSTANCE.toClientDto(client1);
        }
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto getByTelephone(String telephone) {
        Client client = clientRepository.getClientByTelephone(telephone);
        if (client !=null) {
            return ClientMapper.INSTANCE.toClientDto(client);
        }
       throw new ClientException("Client with this telephone was not found");
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
            client1.setActiveStatus(false);
            clientRepository.save(client1);
            return 1;
        }
        return 0;
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElse(null);
        if (client == null) {
            throw new ClientException("Client with this ID was not found");
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
    public int activateClient(Long id) {
        if (clientRepository.existsById(id)){
            Client client1 = clientRepository.getById(id);
            client1.setActiveStatus(true);
            clientRepository.save(client1);
            return 1;
        }
        return 0;
    }
}

