package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClientDto(Client client);

    ClientDto toClient(ClientDto clientDto);

    List<Client> toClientDtoList(List<Client> clientList);

    List<ClientDto> toClientList(List<ClientDto> clientDtoList);
}
