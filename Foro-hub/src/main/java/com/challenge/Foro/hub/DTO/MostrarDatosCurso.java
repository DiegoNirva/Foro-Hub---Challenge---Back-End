package com.challenge.Foro.hub.DTO;

import java.util.Set;

public record MostrarDatosCurso(
        Long id,
        String nombre,
        String categoria,
        Set<MostrarDatosCurso> mostrarDatosCursoSet) {
}
