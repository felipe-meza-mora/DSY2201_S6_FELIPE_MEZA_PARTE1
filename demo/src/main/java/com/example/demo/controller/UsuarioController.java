package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este ID, no existe en nuestros registros.");
        }
    }

     //CONTROLADORES NUEVO CRUD

     @PostMapping
     public Usuario creatUsuario(@RequestBody Usuario usuario){
         return usuarioService.createUsuario(usuario);
     }
 
     @PutMapping("/{id}")
     public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
         return usuarioService.updateUsuario(id, usuario);
     }
 
     @DeleteMapping("/{id}")
     public void deleteUsuario(@PathVariable Integer id){
         usuarioService.deleteUsuario(id);
     }
     
    
    
}
