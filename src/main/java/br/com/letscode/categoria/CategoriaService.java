package br.com.letscode.categoria;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoriaService {

    @Inject
    private CategoriaMapper categoriaMapper;

    @Transactional
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria.persist();
        return categoriaMapper.toDomain(categoria);
    }

    public List<CategoriaDTO> listClients() {
        return Categoria.listAll().stream()
                .map(categoria -> categoriaMapper.toDomain((Categoria) categoria))
                .collect(Collectors.toList());
    }

    @Transactional
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = Categoria.findById(id);
        categoria.code = categoriaDTO.getCode();
        categoria.name = categoriaDTO.getName();
        categoria.persist();
        return categoriaMapper.toDomain(categoria);
    }

    @Transactional
    public void delete(Long id) {
        Categoria.deleteById(id);
    }

    public CategoriaDTO findByCode(String code) {
        return categoriaMapper.toDomain(Categoria.findByCode(code));
    }
}
