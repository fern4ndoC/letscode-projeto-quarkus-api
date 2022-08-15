package br.com.letscode.categoria;

import org.mapstruct.Mapper;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface CategoriaMapper {

    CategoriaDTO toDomain(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
