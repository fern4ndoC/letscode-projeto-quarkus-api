package br.com.letscode.categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaDTO {
    @NotNull
    @NotEmpty(message = "O código é obrigatório.")
    public String code;

    @NotNull
    @NotEmpty(message = "O nome é obrigatório.")
    @Column(unique = true)
    public String name;
}
