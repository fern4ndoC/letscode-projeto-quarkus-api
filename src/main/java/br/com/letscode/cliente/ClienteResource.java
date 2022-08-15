package br.com.letscode.cliente;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteService clienteService;

    @POST
    @Path("/create")
    public ClienteDTO create(@Valid ClienteDTO clienteDTO) {
        return clienteService.create(clienteDTO);
    }

    @GET
    @Path("/list")
    public List<ClienteDTO> list() {
        return clienteService.listClients();
    }

    @PUT
    @Path(("/{id}"))
    public ClienteDTO update(@Valid @PathParam Long id, ClienteDTO clienteDTO) {
        return clienteService.update(id, clienteDTO);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam Long id){
        clienteService.delete(id);
    }
}
