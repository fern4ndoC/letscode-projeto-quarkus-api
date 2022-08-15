package br.com.letscode.categoria;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoriaDTO {
    @NotNull
    @NotEmpty(message = "O código é obrigatório.")
    public String code;

    @NotNull
    @NotEmpty(message = "O nome é obrigatório.")
    public String name;
}
