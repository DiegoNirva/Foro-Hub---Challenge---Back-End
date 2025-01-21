package com.challenge.Foro.hub.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosUsuarios(
        @NotNull
        String login,
        @NotNull
        String clave) {

}
