package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Topico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        String autor,
        @NotNull
        String curso) {

}