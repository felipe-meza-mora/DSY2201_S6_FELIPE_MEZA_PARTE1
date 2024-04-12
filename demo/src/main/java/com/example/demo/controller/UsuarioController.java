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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        log.info("GET /usuarios");
        log.info("Retornado todos los usuarios");
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);

        if(usuario.isEmpty()){
            log.error("No se encontro el usuario con ID: {}",id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontró el Usuario con el ID: " + id));
        }
        log.info("Usuario encontrado con exito");
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

     //CONTROLADORES NUEVO CRUD

     @PostMapping
     public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario){
        Usuario createUsuario = usuarioService.createUsuario(usuario);
        if(createUsuario == null){
          log.error("Error al crear el usuario {}",usuario);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el Usuario"));
        }
        return ResponseEntity.ok("El usuario fue creado correctamente");
     }
 
     @PutMapping("/{id}")
     public ResponseEntity<Object> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
         Usuario updateUsuario = usuarioService.updateUsuario(id, usuario);
         if(updateUsuario == null){
            log.error("Error al modificar el usuario {}",usuario);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al modificar el Usuario"));
         }
         log.info("Usuario modificado con exito");
         //return ResponseEntity.ok(updateUsuario);
         return ResponseEntity.ok("Usuario con ID " + id + " fue modificado correctamente");
     }
 
     @DeleteMapping("/{id}")
     public  ResponseEntity<Object> deleteUsuario(@PathVariable("id") Integer id){
        boolean deleted = usuarioService.deleteUsuario(id);
        if(deleted){
            log.info("Usuario eliminado con éxito");
            return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente");
        } else {
            log.error("Error al eliminar el usuario con ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se puede eliminar el Usuario con el ID: " + id));
        }
     }


     static class ErrorResponse {
        private final String message;
        
        public ErrorResponse(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
     }
     
    
}
