package com.challenge.Foro.hub.controller;

import com.challenge.Foro.hub.DTO.DatosUsuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosUsuarios datosUsuarios){
        Authentication token = new UsernamePasswordAuthenticationToken(datosUsuarios.login(), datosUsuarios.clave());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
