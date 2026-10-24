package cl.duoc.app1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class LibroRequest {

    @PositiveOrZero (message = "debe ingresar libro id")
    Long id;

    @NotBlank (message = "debe ingresar titulo de libro")
    String titulo;

    @NotBlank (message = "debe ingresar nombre de autor")
    String autor;

    @NotNull (message = "debe ingresar año de publicacion")
    Long anio;

    @NotBlank (message = "debe ingresar genero del libro")
    String genero;

    boolean activo;
    
}
