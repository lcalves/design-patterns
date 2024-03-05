package br.com.lcalves.designpatterns.application.services.impl;

import br.com.lcalves.designpatterns.application.dtos.EnderecoDTO;
import br.com.lcalves.designpatterns.application.mappers.AdressMapper;
import br.com.lcalves.designpatterns.application.services.AdressService;
import br.com.lcalves.designpatterns.domain.model.Adress;
import br.com.lcalves.designpatterns.domain.repository.AdressRepository;
import br.com.lcalves.designpatterns.infrastructure.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements AdressService {

    private final ViaCepClient viaCepClient;
    private final AdressRepository adressRepository;

    private final AdressMapper adressMapper;

    @Autowired
    public AdressServiceImpl(final ViaCepClient viaCepClient, final AdressRepository adressRepository,
                             final AdressMapper adressMapper) {
        this.viaCepClient = viaCepClient;
        this.adressRepository = adressRepository;
        this.adressMapper = adressMapper;
    }


    @Override
    public Adress getAdress(String zipCode) {

        return adressRepository.findById(zipCode).orElseGet(() -> {
            EnderecoDTO newAdress = viaCepClient.consultarCep(zipCode);
            adressRepository.save(adressMapper.toModel(newAdress));
            return adressRepository.save(adressMapper.toModel(newAdress));
        });

    }
}
