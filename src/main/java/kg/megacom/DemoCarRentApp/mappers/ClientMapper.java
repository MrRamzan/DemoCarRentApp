package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toClientDto(Client client);

    Client toClient(ClientDto clientDto);

    List<ClientDto> toClientDtoList(List<Client> clientList);

    List<Client> toClientList(List<ClientDto> clientDtoList);
}
