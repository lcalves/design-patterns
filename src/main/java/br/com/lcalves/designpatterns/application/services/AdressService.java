package br.com.lcalves.designpatterns.application.services;

import br.com.lcalves.designpatterns.domain.model.Adress;

public interface AdressService {

    Adress getAdress(String zipCode);
}
