package br.com.letscode.cliente;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ClienteResource {

    @Inject
    private ClienteMapper clienteMapper;

    @POST
    @Transactional
    public ClienteDTO create(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.persist();
        return clienteMapper.toDomain(cliente);
    }

    @GET
    public List<Cliente> list() {
        return Cliente.listAll();
    }

    @PUT
    @Path(("/{id}"))
    @Transactional
    public ClienteDTO update(@Valid @PathParam Long id, ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.findById(id);
        cliente.name = clienteDTO.getName();
        cliente.age = clienteDTO.getAge();
        cliente.vatNumber = clienteDTO.getVatNumber();
        cliente.email = clienteDTO.getEmail();
        cliente.persist();
        return clienteMapper.toDomain(cliente);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam Long id){
        Cliente cliente = Cliente.findById(id);
        cliente.delete();
    }
}
