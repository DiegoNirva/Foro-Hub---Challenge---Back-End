package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.DTO.DatosActualizarCurso;
import com.challenge.Foro.hub.DTO.DatosCurso;
import com.challenge.Foro.hub.DTO.MostrarDatosCurso;
import com.challenge.Foro.hub.model.Curso;
import com.challenge.Foro.hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public MostrarDatosCurso listadoCursosPorId(Long id) {
        //traemos el id y verificamos

        MostrarDatosCurso mostrarDatosCursoId;

        Curso curso = cursoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el curso ID:"+id));

        mostrarDatosCursoId = new MostrarDatosCurso(curso);

        return mostrarDatosCursoId;
    }

    public void actualizarCurso(Long id, @Valid DatosActualizarCurso datosActualizarCurso) {

        //traemos el id
        Curso curso = cursoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el curso ID:"+id));
        curso.setNombre(datosActualizarCurso.nombre());
        curso.setCategoria(datosActualizarCurso.categoria());
        cursoRepository.save(curso);

    }

    public void eliminarCurso(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el curso con ID: " + id));
        cursoRepository.delete(curso);
    }
}
