package br.com.letscode.cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService {

    @Inject
    private ClienteMapper clienteMapper;

    @Transactional
    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.persist();
        return clienteMapper.toDomain(cliente);
    }

    public List<ClienteDTO> listClients() {
        return Cliente.listAll().stream()
                .map(client -> clienteMapper.toDomain((Cliente) client))
                .collect(Collectors.toList());
    }

    @Transactional
    public ClienteDTO update(long id, ClienteDTO clienteDTO){
        Cliente cliente = Cliente.findById(id);
        cliente.name = clienteDTO.getName();
        cliente.age = clienteDTO.getAge();
        cliente.vatNumber = clienteDTO.getVatNumber();
        cliente.email = clienteDTO.getEmail();
        cliente.persist();
        return clienteMapper.toDomain(cliente);
    }

    @Transactional
    public void delete(long id) {
        Cliente.deleteById(id);
    }
}
