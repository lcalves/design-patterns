package br.com.lcalves.designpatterns.application.mappers;

import br.com.lcalves.designpatterns.application.dtos.response.ClienteResponse;
import br.com.lcalves.designpatterns.domain.model.Client;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {AdressMapper.class})
public interface ClientMapper {

    @Mapping(target = "cadastro", source = "registration")
    @Mapping(target = "nome", source = "name")
    @Mapping(target = "endereco", source = "adress")
    ClienteResponse toResponse(Client client);

    List<ClienteResponse> toResponse(List<Client> clients);

}
