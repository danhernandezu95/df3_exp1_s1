package cl.duoc.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.app1.dto.LibroRequest;
import cl.duoc.app1.dto.LibroResponse;
import cl.duoc.app1.services.LibroServices;
import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/biblioteca/libro")
public class LibroController {

    @Autowired 
    LibroServices libroServices;

    public LibroController() {}

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("prueba");
        return ResponseEntity.ok("prueba");
    }

    @GetMapping
    public ResponseEntity<List<LibroResponse>> getLibros() {
        return ResponseEntity.ok(libroServices.getAllLibro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> getLibroById (@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.getLibroById(id));
    }

    @PostMapping
    public ResponseEntity<LibroResponse> createLibro (@Valid @RequestBody LibroRequest libro) {
        return ResponseEntity.ok(libroServices.createLibro(libro));
    }

    @PutMapping
    public ResponseEntity<LibroResponse> updateLibro (@Valid @RequestBody LibroRequest libro) {
        return ResponseEntity.ok(libroServices.updateLibro(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> disableLibro (@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.disableLibro(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro (@PathVariable Long id) {
        return ResponseEntity.ok(libroServices.deleteLibro(id));
    }
    
}
