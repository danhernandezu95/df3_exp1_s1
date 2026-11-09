package cl.duoc.app1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class UsuarioRequest {

    @PositiveOrZero (message = "debe ingresar usuario id")
    Long id;

    @NotBlank (message = "debe ingresar nombre de usuario")
    String username;

    @NotBlank (message = "debe ingresar contraseña")
    String password;


    @NotBlank (message = "debe ingresar rol usuario")
    String role;
    
}
