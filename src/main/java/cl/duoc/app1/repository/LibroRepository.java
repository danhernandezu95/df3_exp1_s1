package cl.duoc.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.app1.model.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    
}
