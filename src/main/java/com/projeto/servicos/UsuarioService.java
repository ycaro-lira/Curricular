package com.projeto.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.entidades.Usuario;
import com.projeto.repositorios.UsuarioRepositorio;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario obterUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }
}
