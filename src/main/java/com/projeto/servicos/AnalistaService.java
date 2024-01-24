package com.projeto.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.entidades.Analista;
import com.projeto.repositorios.AnalistaRepositorio;
import java.util.List;

@Service
public class AnalistaService {

    @Autowired
    private AnalistaRepositorio analistaRepositorio;

    public List<Analista> listarTodosAnalistas() {
        return analistaRepositorio.findAll();
    }

    public Analista obterAnalistaPorId(Long id) {
        return analistaRepositorio.findById(id).orElse(null);
    }

    public Analista salvarAnalista(Analista analista) {
        return analistaRepositorio.save(analista);
    }

    public void excluirAnalista(Long id) {
        analistaRepositorio.deleteById(id);
    }
}
