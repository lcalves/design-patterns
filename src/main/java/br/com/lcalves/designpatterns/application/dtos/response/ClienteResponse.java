package br.com.lcalves.designpatterns.application.dtos.response;

import br.com.lcalves.designpatterns.application.dtos.EnderecoDTO;

import java.io.Serializable;

public class ClienteResponse implements Serializable {


    private String cadastro;
    private String nome;
    private EnderecoDTO endereco;

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

}
