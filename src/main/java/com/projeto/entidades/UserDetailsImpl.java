package com.projeto.entidades;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Analista analista;
   

    public UserDetailsImpl(Analista analista) {
        this.analista = analista;
    }

   

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return Collections.EMPTY_LIST;
    }

    @Override
    public String getPassword() {
        if (analista != null) {
            return analista.getSenha();
        }
        return null;
    }

    @Override
    public String getUsername() {
        if (analista != null) {
            return analista.getEmail();
        }
       
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implemente lógica específica se necessário
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implemente lógica específica se necessário
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implemente lógica específica se necessário
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implemente lógica específica se necessário
        return true;
    }
}