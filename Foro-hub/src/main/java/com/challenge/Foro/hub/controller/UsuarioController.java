package com.challenge.Foro.hub.controller;

import com.challenge.Foro.hub.DTO.DatosRegistroUsuario;
import com.challenge.Foro.hub.DTO.MostrarDatosCurso;
import com.challenge.Foro.hub.DTO.MostrarDatosUsuario;
import com.challenge.Foro.hub.model.Usuario;
import com.challenge.Foro.hub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity guardarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        usuarioService.guardarUsuario(datosRegistroUsuario);
        return ResponseEntity.ok("Se Resgistro el usuario correctamente");
    }

    @GetMapping("mostrar/{id}")
    public ResponseEntity<MostrarDatosUsuario> mostrarDatosUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(new MostrarDatosUsuario(usuarioService.mostrarUsuarioPorId(id)));
    }

    @GetMapping("mostrar")
    public ResponseEntity<PagedModel> listarUsuarios(Pageable pageable, PagedResourcesAssembler assembler, MostrarDatosUsuario mostrarDatosUsuario){
        Page<Usuario> pageListadoUsuarios = usuarioService.listadoUsuarios(pageable);
        Page<MostrarDatosUsuario> mostrarDatosUsuarios = pageListadoUsuarios.map(MostrarDatosUsuario::new);
        return ResponseEntity.ok(assembler.toModel(mostrarDatosUsuarios));
    }

}
