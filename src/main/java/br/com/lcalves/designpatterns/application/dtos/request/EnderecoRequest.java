package br.com.lcalves.designpatterns.application.dtos.request;

import java.io.Serializable;

public class EnderecoRequest implements Serializable {

    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


}
