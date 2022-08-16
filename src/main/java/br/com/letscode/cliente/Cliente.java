package br.com.letscode.cliente;

import br.com.letscode.categoria.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends PanacheEntity {
    public String name;
    public int age;
    public String vatNumber;
    public String email;
    @ManyToOne(cascade = CascadeType.ALL)
    public Categoria categoria;
}