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

import cl.duoc.app1.dto.UsuarioRequest;
import cl.duoc.app1.dto.UsuarioResponse;
import cl.duoc.app1.services.UsuarioServices;
import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/biblioteca/usuario")
public class UsuarioController {

    @Autowired 
    UsuarioServices usuarioServices;

    public UsuarioController() {}

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("prueba");
        return ResponseEntity.ok("prueba");
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getUsuarios() {
        return ResponseEntity.ok(usuarioServices.getAllUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById (@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServices.getUsuarioById(id));
    }

    @GetMapping("/login/{username}&{password}")
    public  ResponseEntity<?> getUsuarioLogin (@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok(usuarioServices.getUsuarioLogin(username, password));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> createUsuario (@Valid @RequestBody UsuarioRequest usuario) {
        return ResponseEntity.ok(usuarioServices.createUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<UsuarioResponse> updateUsuario (@Valid @RequestBody UsuarioRequest usuario) {
        return ResponseEntity.ok(usuarioServices.updateUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario (@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServices.deleteUsuario(id));
    }
    
}