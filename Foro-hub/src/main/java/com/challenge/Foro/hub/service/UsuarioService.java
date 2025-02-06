package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.DTO.DatosRegistroUsuario;
import com.challenge.Foro.hub.model.Curso;
import com.challenge.Foro.hub.model.Rol;
import com.challenge.Foro.hub.model.Usuario;
import com.challenge.Foro.hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void guardarUsuario(DatosRegistroUsuario datosUsuario) {
        System.out.println(datosUsuario);
        //hasheamos la contraseña
        String passwordHash = bCryptPasswordEncoder.encode(datosUsuario.clave());

        //creamos entidad usuario
        Usuario usuario = new Usuario();

        //seteamos datos usuario
        usuario.setLogin(datosUsuario.login());
        usuario.setEmail(datosUsuario.email());
        usuario.setClave(passwordHash);

        //por defecto todos los usuario seran rol USUARIO
        usuario.setRol(Rol.USER);
        System.out.println("usuario");
        usuarioRepository.save(usuario);
    }

    public Usuario mostrarUsuarioPorId(Long id) {
        //traemos el id
        return usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el ID:"+id));
    }


    public Page<Usuario> listadoUsuarios(Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioRepository.findAll(pageable);
        return  usuariosPage;
    }
}
