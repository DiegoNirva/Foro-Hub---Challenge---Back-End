package com.challenge.Foro.hub.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(

        @NotNull
        String nombre,

        @NotNull
        String categoria
) {
}
