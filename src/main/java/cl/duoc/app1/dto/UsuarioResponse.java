package cl.duoc.app1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class UsuarioResponse {
    Long id;
    String username;
    String password;
    String role;
}
