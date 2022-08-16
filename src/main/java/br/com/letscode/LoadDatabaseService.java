package br.com.letscode;

import br.com.letscode.categoria.CategoriaDTO;
import br.com.letscode.categoria.CategoriaService;
import br.com.letscode.cliente.ClienteDTO;
import br.com.letscode.cliente.ClienteService;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class LoadDatabaseService {

    @Inject
    private CategoriaService categoriaService;

    @Inject
    private ClienteService clienteService;

    void onStart(@Observes StartupEvent event) {
        CategoriaDTO categoria1 = new CategoriaDTO("PROG001", "Programador");
        CategoriaDTO categoria2 = new CategoriaDTO("COMR001", "Comerciante");
        categoriaService.create(categoria1);
        categoriaService.create(categoria2);

        ClienteDTO cliente1 = new ClienteDTO("Antônio", 18,
                "BR736291084", "antonio@exemplo.com", categoria1);
        ClienteDTO cliente2 = new ClienteDTO("Carla", 22,
                "BR539280537", "carla@exemplo.com", categoria2);
        clienteService.create(cliente1);
        clienteService.create(cliente2);
    }
}
