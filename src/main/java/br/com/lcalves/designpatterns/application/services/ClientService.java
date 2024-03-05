package br.com.lcalves.designpatterns.application.services;

import br.com.lcalves.designpatterns.application.dtos.request.ClienteRequest;
import br.com.lcalves.designpatterns.application.dtos.response.ClienteResponse;

public interface ClientService {

    Iterable<ClienteResponse> findAll();

    ClienteResponse findByRegistration(String registration);

    ClienteResponse insert(ClienteRequest cliente);

    ClienteResponse update(String registration, ClienteRequest cliente);

    void delete(String registration);
}
