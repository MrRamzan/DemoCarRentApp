package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.ClientRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.ClientMapper;
import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.android.Response;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    Response response = new Response();

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
        if (client == null) {
            return null;
        }
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto getByTelephone(String telephone) {
        Client client = clientRepository.getClientByTelephone(telephone);
        if (client != null) {
            return ClientMapper.INSTANCE.toClientDto(client);
        }
        throw new GeneralException("Client with this telephone was not found");
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client newClient = ClientMapper.INSTANCE.toClient(clientDto);
        Client clientFromDB = clientRepository.getClientByEmail(clientDto.getEmail());

        if (clientFromDB != null) {
            throw new GeneralException("Client with this email exist");
        }
        clientRepository.save(newClient);
        return ClientMapper.INSTANCE.toClientDto(newClient);

    }

    @Override
    public Response deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            Client newClient = clientRepository.getById(id);
            newClient.setActiveStatus(false);
            clientRepository.save(newClient);

            if (newClient.getActiveStatus().equals(false)) {
                response.setCode(1);
                response.setMessage("Клиент деактивирован");
                return response;
            }
            response.setMessage("Клиент ны был деактивирован");
            return response;
        }
        response.setMessage("Клиент не найден");
        return response;
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElse(null);
        if (client == null) {
            throw new GeneralException("Client with this ID was not found");
        }
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setTelephone(clientDto.getTelephone());
        clientRepository.save(client);
        return ClientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public Response activateClient(Long id) {
        if (clientRepository.existsById(id)) {
            Client newClient = clientRepository.getById(id);
            newClient.setActiveStatus(true);
            clientRepository.save(newClient);

            if (newClient.getActiveStatus().equals(true)) {
                response.setCode(1);
                response.setMessage("Клиент активирован");
                return response;
            }
            response.setMessage("Клиент ны был активирован");
            return response;
        }
        response.setMessage("Клиент не найден");
        return response;
    }
}

