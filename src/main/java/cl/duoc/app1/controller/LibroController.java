
package cl.duoc.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.app1.dto.LibroRequest;
import cl.duoc.app1.dto.LibroResponse;
import cl.duoc.app1.services.LibroServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/biblioteca/libro")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {

    @Autowired
    LibroServices libroServices;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("prueba");
    }

    @GetMapping
    public ResponseEntity<List<LibroResponse>> getLibros() {
        return ResponseEntity.ok(libroServices.getAllLibro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> getLibroById(@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.getLibroById(id));
    }

    @PostMapping
    public ResponseEntity<LibroResponse> createLibro(
            @Valid @RequestBody LibroRequest libro) {
        return ResponseEntity.ok(libroServices.createLibro(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> updateLibro(
            @PathVariable Long id,
            @Valid @RequestBody LibroRequest libro) {

        libro.setId(id);
        return ResponseEntity.ok(libroServices.updateLibro(libro));
    }

    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Boolean> disableLibro(@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.disableLibro(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLibro(@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.deleteLibro(id));
    }
}
