package cl.duoc.app1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import cl.duoc.app1.dto.UsuarioRequest;
import cl.duoc.app1.dto.UsuarioResponse;
import cl.duoc.app1.model.UsuarioEntity;
import cl.duoc.app1.repository.UsuarioRepository;

@Service 
public class UsuarioServicesImpl implements UsuarioServices {
    @Autowired 
    UsuarioRepository usuarioRepository;

    @Override 
    public List<UsuarioResponse> getAllUsuario() {
        return usuarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override 
    public UsuarioResponse getUsuarioById(Long id) {
        if(usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id).map(this::toDTO).get();
        } else {
            return new UsuarioResponse();
        }
        
    }

    @Override 
    public  boolean getUsuarioLogin(String username, String password) {
        UsuarioEntity ex = new UsuarioEntity(null, username.trim(), password.trim(), null);
        List<UsuarioEntity> ret = usuarioRepository.findAll(Example.of(ex));
        if (ret != null && ret.size() > 0) return true;
        return false;
    }

    @Override 
    public UsuarioResponse createUsuario (UsuarioRequest nuevo) {
        UsuarioEntity usuario = toEntity(nuevo);
        usuario.setId(null);
        return toDTO(usuarioRepository.saveAndFlush(usuario));
    }

    @Override 
    public UsuarioResponse updateUsuario(UsuarioRequest nuevo) {
        return toDTO(usuarioRepository.saveAndFlush(toEntity(nuevo)));
    }

    @Override 
    public boolean deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        
        return false;
    }

    UsuarioResponse toDTO(UsuarioEntity Usuario) {
        return new UsuarioResponse (Usuario.getId(), Usuario.getUsername(), Usuario.getPassword(),
    Usuario.getRole());
    }

    UsuarioEntity toEntity(UsuarioRequest Usuario) {
        return new UsuarioEntity(Usuario.getId(), Usuario.getUsername(), Usuario.getPassword(),
    Usuario.getRole());
    }
}