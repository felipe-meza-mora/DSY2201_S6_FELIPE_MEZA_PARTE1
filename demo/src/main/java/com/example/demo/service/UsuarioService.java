package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Integer id);

    //CRUD
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
    
}
