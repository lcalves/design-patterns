package br.com.lcalves.designpatterns.application.dtos.request;

import java.io.Serializable;

public class ClienteRequest implements Serializable {


    private String nome;
    private EnderecoRequest endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }
}
