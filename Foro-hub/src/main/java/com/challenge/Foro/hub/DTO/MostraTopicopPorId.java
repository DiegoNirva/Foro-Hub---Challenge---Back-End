package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Topico;

public record MostraTopicopPorId(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        int status,
        String autor,
        String curso) {

    public MostraTopicopPorId(Topico topico){
        this(   topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}