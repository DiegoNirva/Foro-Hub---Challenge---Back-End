package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.DTO.DatosTopico;
import com.challenge.Foro.hub.repository.TopicoRepository;
import com.challenge.Foro.hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    private void saveTopico(DatosTopico datosTopicos){

    }

}
