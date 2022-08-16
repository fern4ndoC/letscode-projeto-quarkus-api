package br.com.letscode.cliente;

import br.com.letscode.categoria.Categoria;
import br.com.letscode.categoria.CategoriaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
    @NotNull
    @NotEmpty(message = "O nome é obrigatório.")
    @Size(min = 5, max = 100)
    private String name;

    @NotNull
    @Min(value = 18)
    private int age;

    @NotNull
    @NotEmpty(message = "O VAT number é obrigatório.")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{9}$", message = "Formato inválido para o VAT.")
    private String vatNumber;

    @NotNull
    @NotEmpty(message = "O email é obrigatório.")
    private String email;

    @NotNull
    private CategoriaDTO categoria;
}
