package br.com.letscode.categoria;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    private CategoriaService categoriaService;

    @POST
    @Path("/create")
    public CategoriaDTO create(@Valid CategoriaDTO categoriaDTO) {
        return categoriaService.create(categoriaDTO);
    }

    @GET
    @Path("/list")
    public List<CategoriaDTO> list() {
        return categoriaService.listClients();
    }

    @PUT
    @Path(("/{id}"))
    public CategoriaDTO update(@Valid @PathParam Long id, CategoriaDTO categoriaDTO) {
        return categoriaService.update(id, categoriaDTO);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam Long id){
        categoriaService.delete(id);
    }
}
