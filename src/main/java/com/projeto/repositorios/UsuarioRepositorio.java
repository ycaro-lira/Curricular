package com.projeto.repositorios;

import com.projeto.entidades.Analista;
import com.projeto.entidades.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	
    
}
