package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService   {

    @Autowired
    UsuarioRepository usuarioRepository;

    //creamos un metodo para buscar usuario en bd y devuelve un Userdetails por el contexto de spring
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findBylogin(username);
    }
}
