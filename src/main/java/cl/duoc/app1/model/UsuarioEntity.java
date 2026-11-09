package cl.duoc.app1.model;

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
@Table(name ="USUARIO")
@NoArgsConstructor 
@AllArgsConstructor 
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_gen")
    @SequenceGenerator(
        name = "usuario_gen", 
        sequenceName = "SEQ_USUARIO_ID", 
        allocationSize = 1
    )
    @Column(name ="ID_USUARIO")
    Long id;

    @Column(name ="USERNAME")
    String username;

    @Column(name ="PASSWORD")
    String password;

    @Column(name ="USER_ROLE")
    String role;
}
