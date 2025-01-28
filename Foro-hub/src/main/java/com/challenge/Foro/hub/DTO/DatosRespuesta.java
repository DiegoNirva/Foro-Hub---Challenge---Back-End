package com.challenge.Foro.hub.DTO;

import jakarta.validation.constraints.NotBlank;

public record DatosRespuesta(
        @NotBlank
        String mensaje,
        @NotBlank
        MostraDatosTopico mostraTopicopPorId,
        @NotBlank
        MostrarDatosUsuario mostrarDatosUsuario
) {
}
