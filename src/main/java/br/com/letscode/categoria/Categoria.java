package br.com.letscode.categoria;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Categoria extends PanacheEntity {
    public String code;
    public String name;
}
