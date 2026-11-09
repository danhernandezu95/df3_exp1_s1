package cl.duoc.app1.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="LIBRO")
@NoArgsConstructor 
@AllArgsConstructor 
public class LibroEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_gen")
    @SequenceGenerator(
        name = "libro_gen", 
        sequenceName = "SEQ_LIBRO_ID", 
        allocationSize = 1
    )
    @Column(name ="id_libro")
    @JsonProperty("id")
    Long id;

    @Column(name ="titulo")
    String titulo;

    @Column(name ="autor")
    String autor;

    @Column(name ="anio")
    Long anio;

    @Column(name ="genero")
    String genero;

    @Column(name = "activo")
    boolean activo = true;
}
