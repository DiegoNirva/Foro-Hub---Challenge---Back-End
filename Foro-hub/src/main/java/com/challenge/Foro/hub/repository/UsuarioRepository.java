package com.challenge.Foro.hub.repository;

import com.challenge.Foro.hub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //busqueda personalizada
    UserDetails findBylogin(String username);
}
