package com.challenge.Foro.hub.controller;

import com.challenge.Foro.hub.DTO.DatosActualizarCurso;
import com.challenge.Foro.hub.DTO.DatosCurso;
import com.challenge.Foro.hub.DTO.MostrarDatosCurso;
import com.challenge.Foro.hub.model.Curso;
import com.challenge.Foro.hub.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("/guardar")
    public ResponseEntity guardarCurso(@Valid @RequestBody DatosCurso datosCurso){
            cursoService.guardarCurso(datosCurso);
            return ResponseEntity.ok("Curso guardado");
    }

    @GetMapping("/mostrar")
    public ResponseEntity<PagedModel>listadoCursos(Pageable pageable, PagedResourcesAssembler assembler){
            Page<Curso> pageListadoCursos = cursoService.listadoCursos(pageable);
            Page<MostrarDatosCurso> datosCursos = pageListadoCursos.map(MostrarDatosCurso::new);
            return ResponseEntity.ok(assembler.toModel(datosCursos));
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<MostrarDatosCurso>cursosPorId(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.listadoCursosPorId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso, @PathVariable Long id){
        cursoService.actualizarCurso(id, datosActualizarCurso);
        return ResponseEntity.ok("Se actualizo el curso");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
        return ResponseEntity.ok("Se elimino el curso con ID:"+id);
    }

}
