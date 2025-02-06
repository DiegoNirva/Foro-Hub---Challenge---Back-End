package com.challenge.Foro.hub.controller;

import com.challenge.Foro.hub.DTO.DatosJwtToken;
import com.challenge.Foro.hub.DTO.DatosRegistroUsuario;
import com.challenge.Foro.hub.DTO.DatosUsuario;
import com.challenge.Foro.hub.util.JwtUtils;
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

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosUsuario datosUsuarios){
        Authentication token = new UsernamePasswordAuthenticationToken(datosUsuarios.login(), datosUsuarios.clave());
        authenticationManager.authenticate(token);
        var JWTtoken = jwtUtils.createToken(token);
        return ResponseEntity.ok(new DatosJwtToken(JWTtoken));
    }
}
