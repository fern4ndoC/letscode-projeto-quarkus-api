package br.com.letscode.cliente;

import org.mapstruct.Mapper;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ClienteMapper {
    ClienteDTO toDomain(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
}
