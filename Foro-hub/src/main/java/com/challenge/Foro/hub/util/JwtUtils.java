package com.challenge.Foro.hub.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {


//definimos clave privada y usuario para el token
    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    //creacion del token
    public String createToken(Authentication authentication){
        try{
        //definimos el tipo de algoritmo y pasamos la clave del token
        Algorithm algorithm =Algorithm.HMAC256(privateKey);

        //traemos el nombre del usuario autenticado
        String username = authentication.getPrincipal().toString();

        //creamos cuerpo del token
        String JwtToken = JWT.create()
                .withIssuer(userGenerator)
                .withSubject(username)
                .withClaim("Id", (List<?>) authentication.getAuthorities())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))
                .sign(algorithm);
        return JwtToken;
        } catch (JWTCreationException exception){
            throw new RuntimeException();
    }



    }

    //verificador de token
    public DecodedJWT validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            //verificamos
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(userGenerator)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT;
        }catch (JWTVerificationException exception){
            throw new JWTVerificationException("token invalido, no autorizado");
        }
    }

    //metodo para extrar username
    public String extractUsername(DecodedJWT decodedJWT){
        return decodedJWT.getSubject().toString();
    }
}
