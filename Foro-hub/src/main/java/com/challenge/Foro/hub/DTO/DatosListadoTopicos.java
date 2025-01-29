package com.challenge.Foro.hub.DTO;

import com.challenge.Foro.hub.model.Topico;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        int status,
        String autor,
        String curso) {

    public DatosListadoTopicos(Topico topico){
            this(   topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaDeCreacion(),
                    topico.getStatus(),
                    topico.getUsuario().getLogin(),
                    topico.getCurso().getNombre());
    }


}
