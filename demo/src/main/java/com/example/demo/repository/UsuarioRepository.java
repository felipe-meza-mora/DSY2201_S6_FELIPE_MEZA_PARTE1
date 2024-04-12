package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>  {

    boolean existsByUsuarioAndPassword(String usuario, String password);
}
