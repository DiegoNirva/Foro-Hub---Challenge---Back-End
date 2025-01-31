package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Topico;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record DatosCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria,

        Set<DatosTopico> topicos
) {

}
