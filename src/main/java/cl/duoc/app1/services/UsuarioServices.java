package cl.duoc.app1.services;

import java.util.List;

import cl.duoc.app1.dto.UsuarioRequest;
import cl.duoc.app1.dto.UsuarioResponse;

public interface UsuarioServices {
    List<UsuarioResponse> getAllUsuario();
    UsuarioResponse getUsuarioById(Long id);
    boolean getUsuarioLogin(String username, String password);
    UsuarioResponse createUsuario(UsuarioRequest nuevo);
    UsuarioResponse updateUsuario(UsuarioRequest nuevo);
    boolean deleteUsuario(Long usuarioId);
}
