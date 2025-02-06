package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Rol;
import com.challenge.Foro.hub.model.Usuario;

public record MostrarDatosUsuario(
        Long id,
        String login,
        String email,
        String rol
) {
    public MostrarDatosUsuario(Usuario usuario){
        this(   usuario.getId(),
                usuario.getLogin(),
                usuario.getEmail(),
                String.valueOf(usuario.getRol()));
    }
}
