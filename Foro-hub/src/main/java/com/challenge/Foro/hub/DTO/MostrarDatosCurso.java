package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Curso;
import com.challenge.Foro.hub.model.Topico;

import java.util.Set;

public record MostrarDatosCurso(
        Long id,
        String nombre,
        String categoria,
        Set<Topico> topicos) {

    public MostrarDatosCurso(Curso curso){
        this(curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getTopico());
    }
}
