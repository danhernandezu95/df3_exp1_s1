package cl.duoc.app1.services;

import java.util.List;

import cl.duoc.app1.dto.LibroRequest;
import cl.duoc.app1.dto.LibroResponse;

public interface LibroServices {
    List<LibroResponse> getAllLibro();
    LibroResponse getLibroById(Long id);
    LibroResponse createLibro(LibroRequest nuevo);
    LibroResponse updateLibro(LibroRequest nuevo);
    boolean disableLibro(Long libroId);
    boolean deleteLibro(Long libroId);
}
