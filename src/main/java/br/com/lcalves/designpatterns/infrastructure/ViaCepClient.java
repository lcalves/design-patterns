package br.com.lcalves.designpatterns.infrastructure;

import br.com.lcalves.designpatterns.application.dtos.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    EnderecoDTO consultarCep(@PathVariable("cep") String cep);
}
