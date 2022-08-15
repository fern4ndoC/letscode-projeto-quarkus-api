package br.com.letscode.cliente;

import br.com.letscode.categoria.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {
    public String name;
    public int age;
    public String vatNumber;
    public String email;
    //private Categoria categoria;
}