package cl.duoc.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.app1.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
}