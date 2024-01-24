package com.projeto.servicos;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.projeto.entidades.Analista;
import com.projeto.entidades.Usuario;
import com.projeto.entidades.UserDetailsImpl;
import com.projeto.repositorios.AnalistaRepositorio;
import com.projeto.repositorios.UsuarioRepositorio;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AnalistaRepositorio analistaRepositorio;
 
    
 
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Analista analista = analistaRepositorio.findByEmail(email)
            .orElse(null);
 
        if (analista != null) {
            return new UserDetailsImpl(analista);
        }
		return null;
 
       
}
}