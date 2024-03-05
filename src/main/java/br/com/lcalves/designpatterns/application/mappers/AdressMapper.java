package br.com.lcalves.designpatterns.application.mappers;

import br.com.lcalves.designpatterns.application.dtos.EnderecoDTO;
import br.com.lcalves.designpatterns.domain.model.Adress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    @Mapping(target = "cep", source = "zipCode")
    @Mapping(target = "logradouro", source = "street")
    @Mapping(target = "complemento", source = "complement")
    @Mapping(target = "bairro", source = "neighborhood")
    @Mapping(target = "localidade", source = "locality")
    @Mapping(target = "uf", source = "state")
    EnderecoDTO toDTO(Adress adress);

    @Mapping(source = "cep", target = "zipCode")
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "complemento", target = "complement")
    @Mapping(source = "bairro", target = "neighborhood")
    @Mapping(source = "localidade", target = "locality")
    @Mapping(source = "uf", target = "state")
    Adress toModel(EnderecoDTO adress);
}
