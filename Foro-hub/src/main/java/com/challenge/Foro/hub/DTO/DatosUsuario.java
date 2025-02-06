package com.challenge.Foro.hub.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        String login,

        @NotBlank
        String clave) {

}
