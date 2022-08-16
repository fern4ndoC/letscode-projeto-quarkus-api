package br.com.letscode.categoria;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.NoSuchElementException;

@Entity
public class Categoria extends PanacheEntity {
    public String code;
    public String name;

    public static Categoria findByCode(String code){
        return (Categoria) find("code", code).firstResultOptional().orElseThrow(
                () -> new NoSuchElementException("Categoria não existe.")
        );
    }
}
