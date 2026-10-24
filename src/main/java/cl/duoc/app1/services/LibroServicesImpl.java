package cl.duoc.app1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.app1.dto.LibroRequest;
import cl.duoc.app1.dto.LibroResponse;
import cl.duoc.app1.model.LibroEntity;
import cl.duoc.app1.repository.LibroRepository;

@Service 
public class LibroServicesImpl implements LibroServices {
    @Autowired 
    LibroRepository libroRepository;

    @Override 
    public List<LibroResponse> getAllLibro() {
        return libroRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override 
    public LibroResponse getLibroById(Long id) {
        return libroRepository.findById(id).map(this::toDTO).get();
    }

    @Override 
    public LibroResponse createLibro (LibroRequest nuevo) {
        LibroEntity libro = toEntity(nuevo);
        libro.setId(null);
        return toDTO(libroRepository.saveAndFlush(libro));
    }

    @Override 
    public LibroResponse updateLibro(LibroRequest nuevo) {
        return toDTO(libroRepository.saveAndFlush(toEntity(nuevo)));
    }

    @Override 
    public boolean disableLibro(Long id) {
        if (libroRepository.existsById(id)) {
            LibroEntity libro = libroRepository.findById(id).get();
            libro.setActivo(false);
            libroRepository.saveAndFlush(libro);
            return true;
        }
        
        return false;
    }

    @Override 
    public boolean deleteLibro(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        
        return false;
    }

    LibroResponse toDTO(LibroEntity libro) {
        return new LibroResponse (libro.getId(), libro.getTitulo(), libro.getAutor(),
    libro.getAnio(), libro.getGenero(), libro.isActivo());
    }

    LibroEntity toEntity(LibroRequest libro) {
        return new LibroEntity(libro.getId(), libro.getTitulo(), libro.getAutor(),
    libro.getAnio(),libro.getGenero(),libro.isActivo());
    }
}
