package br.com.lcalves.designpatterns.application.services.impl;

import br.com.lcalves.designpatterns.application.dtos.request.ClienteRequest;
import br.com.lcalves.designpatterns.application.dtos.response.ClienteResponse;
import br.com.lcalves.designpatterns.application.mappers.ClientMapper;
import br.com.lcalves.designpatterns.application.services.ClientService;
import br.com.lcalves.designpatterns.application.services.RegistrationNumberGeneratorService;
import br.com.lcalves.designpatterns.domain.model.Adress;
import br.com.lcalves.designpatterns.domain.model.Client;
import br.com.lcalves.designpatterns.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceimpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AdressServiceImpl adressServices;
    private final RegistrationNumberGeneratorService registrationNumberGeneratorService;
    private final ClientMapper clientMapper ;

    public ClientServiceimpl(final ClientRepository clientRepository, final AdressServiceImpl adressServices,
                             final RegistrationNumberGeneratorService registrationNumberGeneratorService,
                             final ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.adressServices = adressServices;
        this.registrationNumberGeneratorService = registrationNumberGeneratorService;
        this.clientMapper = clientMapper;
    }

    @Override
    public Iterable<ClienteResponse> findAll() {

        List<Client> clients = clientRepository.findAll();

        return clientMapper.toResponse(clients);
    }

    @Override
    public ClienteResponse findByRegistration(String registration) {

        Optional<Client> client = clientRepository.findByRegistration(registration);

        return clientMapper.toResponse(client.orElse(new Client()));
    }

    @Override
    public ClienteResponse insert(ClienteRequest cliente) {
        Adress adress = adressServices.getAdress(cliente.getEndereco().getCep());
        Client client = new Client();
        client.setAdress(adress);
        client.setName(cliente.getNome());
        String registration = registrationNumberGeneratorService.generate();
        client.setRegistration(registration);

        return clientMapper.toResponse(clientRepository.save(client));
    }

    @Override
    public ClienteResponse update(String registration, ClienteRequest cliente) {

        Optional<Client> clientOpt = clientRepository.findByRegistration(registration);
        if (clientOpt.isPresent()) {
            Adress adress = adressServices.getAdress(cliente.getEndereco().getCep());
            Client client = clientOpt.get();
            client.setAdress(adress);
            return clientMapper.toResponse(clientRepository.save(client));

        }
        return null;
    }

    @Override
    public void delete(String registration) {
        clientRepository.deleteByRegistration(registration);
    }


}
