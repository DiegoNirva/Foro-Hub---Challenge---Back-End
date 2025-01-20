package com.challenge.Foro.hub.controller;

import com.challenge.Foro.hub.DTO.DatosActualizarTopico;
import com.challenge.Foro.hub.DTO.DatosListadoTopicos;
import com.challenge.Foro.hub.DTO.DatosTopico;
import com.challenge.Foro.hub.DTO.MostraTopicopPorId;
import com.challenge.Foro.hub.model.Topico;
import com.challenge.Foro.hub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;


    //crea un topico
    @PostMapping
    public ResponseEntity<String> SaveTopico(@RequestBody @Valid DatosTopico datosTopico){
    topicoService.saveTopico(datosTopico);
        return ResponseEntity.ok("Topico guardado");
    }

    //trae todos los topicos
    @GetMapping("/listado.")
    ResponseEntity<PagedModel> listadoTopicos(Pageable pageable, PagedResourcesAssembler assembler){
        Page<Topico>topicos = topicoService.findAll(pageable);
        Page<DatosListadoTopicos>datosListadoTopicos = topicos.map(DatosListadoTopicos::new);
        return ResponseEntity.ok(assembler.toModel(datosListadoTopicos));
    }

    //busca topicos por curso y anio
    @GetMapping("/listado/{curso}/{anio}.")
    ResponseEntity<PagedModel> busquedaTopicoPorCursoAnio(Pageable pageable, PagedResourcesAssembler assembler, @PathVariable String curso, @PathVariable String anio){
        Page<Topico>topicos = topicoService.findByCursoAndFechaDeCreacion(pageable, curso, anio);
        Page<DatosListadoTopicos>datosListadoTopicos = topicos.map(DatosListadoTopicos::new);
        return ResponseEntity.ok(assembler.toModel(datosListadoTopicos));
    }

    //buscar topicos por id
    @GetMapping("/listado/{id}.")
    public ResponseEntity<MostraTopicopPorId> buscarPorId(@PathVariable Long id){
            return ResponseEntity.ok(topicoService.mostraTopicopPorId(id));
    }

    //actualizar topicos
    @PutMapping("/actualizar/{id}.")
    public ResponseEntity<String> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
            topicoService.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok("Se actualizo datos de ID:"+ id);
    }
}
