package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Respuesta;
import com.challenge.Foro.hub.model.Topico;

import java.util.Set;

public record MostraDatosTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        int status,
        String autor,
        String curso,
        Set<Respuesta>respuestas) {

    public MostraDatosTopico(Topico topico){
        this(   topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getRespuestas());
    }
}