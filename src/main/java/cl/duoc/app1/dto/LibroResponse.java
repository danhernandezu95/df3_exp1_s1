package cl.duoc.app1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class LibroResponse {
    Long id;
    String titulo;
    String autor;
    Long anio;
    String genero;
    boolean activo;
}
