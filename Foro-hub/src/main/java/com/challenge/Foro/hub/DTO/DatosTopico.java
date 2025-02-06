package com.challenge.Foro.hub.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotNull(message = "El titulo no puede estar vacio")
        String titulo,
        @NotNull(message = "El mensaje no puede estar vacio")
        String mensaje,
        @NotNull(message = "El autor no puede estar vacio")
        MostrarDatosUsuario usuario,
        @NotNull(message = "El curso no puede estar vacio")
        MostrarDatosCurso curso) {


}
