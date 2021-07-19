package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAll")
    public List<ClientDto> findAllClient() {
        return clientService.getAllClients();
    }

    @GetMapping("/getByMail")
    public ClientDto getByEmail(@RequestParam String email) {
        return clientService.getByMail(email);
    }

    @GetMapping("/getByPhone")
    public ClientDto getByTelephone(@RequestParam String telephone) {
        return clientService.getByTelephone(telephone);
    }

    @GetMapping("/getById/{id}")
    public ClientDto findById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PostMapping("/save")
    public ClientDto saveNewClient(@RequestBody ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteClient (@PathVariable Long id) {
        return clientService.deleteClient(id);
    }

    @PutMapping("/update/{id}")
    public ClientDto updateClient (@PathVariable Long id, @RequestBody ClientDto clientDto){
        return clientService.update(id, clientDto);
    }

    @PutMapping("/activated/{id}")
    public int activated (@PathVariable Long id) {
        return clientService.activateClient(id);
    }
}
