package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.DTO.DatosCurso;
import com.challenge.Foro.hub.model.Curso;
import com.challenge.Foro.hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public void guardarCurso(DatosCurso datosCurso){
        cursoRepository.save(new Curso(datosCurso));
    }


    public Page<Curso> listadoCursos(Pageable pageable){
        Page<Curso>cursoPage = cursoRepository.findAll(pageable);
        return  cursoPage;
    }
}
